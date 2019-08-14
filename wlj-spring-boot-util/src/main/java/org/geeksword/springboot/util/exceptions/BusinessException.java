package org.geeksword.springboot.util.exceptions;

/**
 * @wenliujie
 */
public class BusinessException extends RuntimeException {


    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
