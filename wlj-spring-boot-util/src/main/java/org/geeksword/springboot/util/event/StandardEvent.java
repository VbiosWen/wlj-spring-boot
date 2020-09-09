package org.geeksword.springboot.util.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author vbiso
 * @see
 */
public class StandardEvent<T> extends ApplicationEvent {

    private T body;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public StandardEvent(Object source,T body) {
        super(source);
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
