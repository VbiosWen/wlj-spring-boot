package org.geeksword.springboot.util.exceptions;

import lombok.Data;

/**
 * @wenliujie
 */
@Data

public class BusinessException extends RuntimeException {


    private static final long serialVersionUID = -1162464335005500665L;

    private final int code;


    public BusinessException(final int code, final String message) {
        super(message);
        this.code = code;
    }
}
