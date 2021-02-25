package org.geeksword.springboot.dubbo.service;

import org.geeksword.springboot.dubbo.api.TestService;
import org.springframework.stereotype.Service;

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
