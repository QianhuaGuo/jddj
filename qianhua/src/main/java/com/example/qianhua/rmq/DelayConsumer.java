//package com.example.qianhua.rmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@RocketMQMessageListener(
//        topic = "delay-topic",
//        consumerGroup = "delay-group")
//public class DelayConsumer implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String message) {
//        //TODO:拿到订单查询判断状态是否已支付，如果未支付，则取消订单，释放库存
//    }
//}
