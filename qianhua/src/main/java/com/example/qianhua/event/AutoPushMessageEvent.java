package com.example.qianhua.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class AutoPushMessageEvent extends ApplicationEvent {

    private String orderID;//订单id



    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AutoPushMessageEvent(Object source,String orderID) {
        super(source);
        this.orderID = orderID;
    }
}
