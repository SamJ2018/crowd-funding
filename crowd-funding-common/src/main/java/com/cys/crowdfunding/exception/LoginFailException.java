package com.cys.crowdfunding.exception;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-9:15
 **/
public class LoginFailException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoginFailException(String message) {
        super(message);
    }

}
