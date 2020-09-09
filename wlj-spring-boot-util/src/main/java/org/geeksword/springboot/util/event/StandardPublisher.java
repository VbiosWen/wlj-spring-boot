package org.geeksword.springboot.util.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author vbiso
 * @see
 */
@Component
public class StandardPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public <T> void publish(T message) {
        applicationContext.publishEvent(new StandardEvent<T>(this, message));
    }
}
