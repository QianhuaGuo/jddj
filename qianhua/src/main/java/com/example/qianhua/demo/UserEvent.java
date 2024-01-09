package com.example.qianhua.demo;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.concurrent.atomic.AtomicReference;

@Data
public class UserEvent extends ApplicationEvent {
    private AtomicReference<String> old;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     * @param old
     */
    public UserEvent(Object source, AtomicReference<String> old) {
        super(source);
        this.old = old;
    }
}
