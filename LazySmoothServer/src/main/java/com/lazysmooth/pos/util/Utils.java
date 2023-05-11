package com.lazysmooth.pos.util;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.service.TableInfoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

    private static final Logger logger = LogManager.getLogger(Utils.class);
    private Utils() {
        throw new IllegalStateException("Utility class");
    }
    public static <T> Object convertJsonToObject(String json, Class<T> className){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, className);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new UtilsConverterException(ex.getMessage());
        }
    }
}
