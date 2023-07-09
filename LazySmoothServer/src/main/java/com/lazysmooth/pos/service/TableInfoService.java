package com.lazysmooth.pos.service;

import com.lazysmooth.pos.db.repository.TableInfoRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.TableInfo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableInfoService {

    private static final Logger logger = LogManager.getLogger(TableInfoService.class);

    private final TableInfoRepository repository;

    public List<TableInfo> getAll() {
        try {
            List<TableInfo> tempTableInfo = repository.findAll();
            List<TableInfo> tableInfoList = tempTableInfo.stream().sorted(
                    Comparator.comparingLong(TableInfo::getTableInfoId)).toList();
            logger.debug("Get All TableInfo: {}", tableInfoList);
            return tableInfoList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public TableInfo getTableInfo(String name) {
        try {
            Optional<List<TableInfo>> opt = Optional.ofNullable(repository.findByName(name));
            List<TableInfo> tableInfoList = opt.orElseGet(ArrayList::new);
            TableInfo tableInfo = tableInfoList.get(0);
            logger.debug("Get TableInfoName: {}, TableInfo: {}", name, tableInfo);
            return tableInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public TableInfo add(TableInfo tableInfo) {
        try {
            repository.save(tableInfo);
            logger.info("Add new TableInfo: {} Successfully.", tableInfo);
            return tableInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }


    public void update(TableInfo tableInfo) {
        try {
            repository.updateTableInfo(tableInfo.getTableInfoId(), tableInfo.getName(), tableInfo.getStatus(), tableInfo.getOrderInfoId());
            logger.info("Updated TableInfo {}", tableInfo);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void updateStatus(String status, String name) {
        try {
            repository.updateTableInfoStatusByName(status, name);
            logger.info("Updated TableInfo Status Name: {}, Status: {}", name, status);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
            logger.info("Deleted TableInfo Id: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

}
