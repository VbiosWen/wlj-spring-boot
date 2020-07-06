package org.geeksword.springboot.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.geeksword.springboot.dubbo.api.TestService;

/**
 * @author vbiso
 * @see
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void sout() {
        System.out.println("Hello word");
    }
}
