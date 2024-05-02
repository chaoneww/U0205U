package com.tibame.u0205u.dto;

import com.tibame.u0205u.enums.StatusCode;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ResDTO<T> {

    private String code;

    @Setter private String message;

    @Setter private T data;

    public ResDTO() {
        this.setStatusCode(StatusCode.SUCCESS);
    }

    public ResDTO(StatusCode statusCode) {
        this.setStatusCode(statusCode);
    }

    public void setStatusCode(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }
}
