package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.model.response.ErrorResponse;
import com.lazysmooth.pos.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class AbstractController {
    private static final Logger logger = LogManager.getLogger(AbstractController.class);

    void logError(String errorMessage, String detail) {
        logger.error("{}:{}", errorMessage, detail);
    }

    String generateErrorResponse(int errorId, String errorMessage, String errorDetail) {
        ErrorResponse errorResponse = new ErrorResponse(errorId, errorMessage, errorDetail);
        return Utils.convertJsonObjecToString(errorResponse);
    }
}
