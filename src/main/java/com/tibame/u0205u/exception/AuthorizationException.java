package com.tibame.u0205u.exception;

/** 登入驗證碼錯誤 */
public class AuthorizationException extends Exception {

    public AuthorizationException(String message) {
        super(message);
    }
}
