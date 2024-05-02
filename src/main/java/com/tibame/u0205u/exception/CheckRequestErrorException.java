package com.tibame.u0205u.exception;

/** 檢查傳入資料不符合 */
public class CheckRequestErrorException extends Exception {

    public CheckRequestErrorException(String message) {
        super(message);
    }
}
