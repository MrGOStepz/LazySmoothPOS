package com.lazysmooth.pos.util;

import com.lazysmooth.pos.exception.UtilsConverterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Utils {

    private static final Logger logger = LogManager.getLogger(Utils.class);
    private Utils() {
        throw new IllegalStateException("Utility class");
    }
    public static <T> Object convertJsonStringToObject(String json, Class<T> className){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, className);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new UtilsConverterException(ex.getMessage());
        }
    }

    public static <T> String convertJsonObjecToString(T object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            throw new UtilsConverterException(ex.getMessage());
        }
    }
}
