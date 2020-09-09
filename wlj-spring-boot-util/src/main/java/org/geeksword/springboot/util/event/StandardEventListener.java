package org.geeksword.springboot.util.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author vbiso
 * @see
 */
@Component
public class StandardEventListener<T> implements ApplicationListener<StandardEvent<T>> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(StandardEvent<T> event) {
        System.out.println(event.getBody());
    }
}
