package org.geeksword.springboot.aop.idempotent;

import javax.servlet.http.HttpServletRequest;

public interface IdempotentStrategy {

    String getLockKey(HttpServletRequest httpServletRequest);
}
