package org.geeksword.springboot.aop.idempotent;

import org.geeksword.springboot.util.encipher.MD5Util;
import org.geeksword.springboot.util.json.JackSonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class PathAndParamsStrategy implements IdempotentStrategy {


    @Override
    public String getLockKey(HttpServletRequest httpServletRequest) {

        String servletPath = httpServletRequest.getServletPath();

        String token = httpServletRequest.getHeader("token");

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();

        String parameters = JackSonUtil.toJson(parameterMap);

        return MD5Util.md5(token + servletPath + parameters);
    }
}
