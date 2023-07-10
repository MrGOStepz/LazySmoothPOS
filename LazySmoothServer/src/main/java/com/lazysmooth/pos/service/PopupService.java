package com.lazysmooth.pos.service;


import com.lazysmooth.pos.db.repository.PopupDetailRepository;
import com.lazysmooth.pos.db.repository.PopupInfoRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.PopupDetail;
import com.lazysmooth.pos.model.db.PopupInfo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PopupService {
    private static final Logger logger = LogManager.getLogger(PopupService.class);

    private final PopupInfoRepository popupInfoRepository;
    private final PopupDetailRepository popupDetailRepository;

    public List<PopupInfo> getPopupInfoAll() {
        try {
            List<PopupInfo> popupInfoList = popupInfoRepository.findAll();
            logger.debug("Get All PopupInfo: {}", popupInfoList);
            return popupInfoList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public PopupInfo getPopupInfoById(Long id) {
        try {
            Optional<PopupInfo> opt = popupInfoRepository.findById(id);
            PopupInfo popupInfo = opt.orElseGet(PopupInfo::new);
            logger.debug("Get PopupInfo: {}", popupInfo);
            return popupInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public PopupInfo addPopupInfo(PopupInfo popupInfo) {
        try {
            var retObject = popupInfoRepository.save(popupInfo);
            popupInfoRepository.flush();
            popupInfo.setId(retObject.getId());
            logger.info("Add new PopupInfo: {} \nSuccessfully.", popupInfo);
            return popupInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void updatePopupInfo(PopupInfo popupInfo) {
        try {
            popupInfoRepository.save(popupInfo);
            logger.info("Updated PopupInfo: {}. Successfully", popupInfo);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void deletePopupInfo(Long id) {
        try {
            popupInfoRepository.deleteById(id);
            logger.info("Deleted PopupInfo: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }


    public List<PopupDetail> getPopupDetailAll() {
        try {
            List<PopupDetail> popupDetailList = popupDetailRepository.findAll();
            logger.debug("Get All PopupDetail: {}", popupDetailList);
            return popupDetailList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public PopupDetail getPopupDetailById(Long id) {
        try {
            Optional<PopupDetail> opt = popupDetailRepository.findById(id);
            PopupDetail popupDetail = opt.orElseGet(PopupDetail::new);
            logger.debug("Get PopupDetail: {}", popupDetail);
            return popupDetail;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public PopupDetail addPopupDetail(PopupDetail popupDetail) {
        try {
            var retObject = popupDetailRepository.save(popupDetail);
            popupDetailRepository.flush();
            popupDetail.setId(retObject.getId());
            logger.info("Add new PopupDetail: {} \nSuccessfully.", popupDetail);
            return popupDetail;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void updatePopupDetail(PopupDetail popupDetail) {
        try {
            popupDetailRepository.save(popupDetail);
            logger.info("Updated PopupDetail: {}. Successfully", popupDetail);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void deletePopupDetail(Long id) {
        try {
            popupDetailRepository.deleteById(id);
            logger.info("Deleted PopupDetail: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }
}

