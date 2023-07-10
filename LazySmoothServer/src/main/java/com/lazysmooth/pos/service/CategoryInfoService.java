package com.lazysmooth.pos.service;

import com.lazysmooth.pos.db.repository.CategoryInfoRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.CategoryInfo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryInfoService {
    private static final Logger logger = LogManager.getLogger(CategoryInfoService.class);

    private final CategoryInfoRepository repository;

    public List<CategoryInfo> getAll() {
        try {
            List<CategoryInfo> categoryInfoList = repository.findAll();
            logger.debug("Get All CategoryInfo: {}", categoryInfoList);
            return categoryInfoList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public CategoryInfo getById(Long id) {
        try {
            Optional<CategoryInfo> opt = repository.findById(id);
            CategoryInfo categoryInfo = opt.orElseGet(CategoryInfo::new);
            logger.debug("Get CategoryInfo: {}", categoryInfo);
            return categoryInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public CategoryInfo add(CategoryInfo categoryInfo) {
        try {
            var retObject = repository.save(categoryInfo);
            repository.flush();
            categoryInfo.setId(retObject.getId());
            logger.info("Add new CategoryInfo: {} \nSuccessfully.", categoryInfo);
            return categoryInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void update(CategoryInfo categoryInfo) {
        try {
            repository.save(categoryInfo);
            logger.info("Updated CategoryInfo: {}. Successfully", categoryInfo);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
            logger.info("Deleted CategoryId: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }
}
