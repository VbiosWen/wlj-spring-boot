package org.geeksword.springboot.util.exceptions;

/**
 * @wenliujie
 */
public class BusinessException extends RuntimeException {


    private static final long serialVersionUID = -1162464335005500665L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
