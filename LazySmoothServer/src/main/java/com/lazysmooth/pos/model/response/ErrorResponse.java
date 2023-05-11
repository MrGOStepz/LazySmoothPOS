package com.lazysmooth.pos.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    public ErrorResponse(int errorId, String message, String detail) {
        this.errorId = errorId;
        this.message = message;
        this.detail = detail;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private int errorId;
    private String message;
    private String detail;
}
