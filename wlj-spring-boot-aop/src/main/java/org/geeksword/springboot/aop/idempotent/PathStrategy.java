package org.geeksword.springboot.aop.idempotent;

import javax.servlet.http.HttpServletRequest;

public class PathStrategy implements IdempotentStrategy {

    @Override
    public String getLockKey(HttpServletRequest httpServletRequest) {

        String token = httpServletRequest.getHeader("token");
        String servletPath = httpServletRequest.getServletPath();

        return token + servletPath;
    }
}
