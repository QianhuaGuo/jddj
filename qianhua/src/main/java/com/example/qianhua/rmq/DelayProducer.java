//package com.example.qianhua.rmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Component
//@Slf4j
//public class DelayProducer {
//    @Autowired
//    private RocketMQTemplate rocketMQTemplatet;
//    public void sendDelayMessage(String topic,String message,int delayLevel){
//        SendResult sendResult = rocketMQTemplatet.syncSend(topic, MessageBuilder.withPayload(message).build(), 2000, delayLevel);
//        log.info("sendtime is {}", DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").format(LocalDateTime.now()));
//        log.info("sendResult is{}",sendResult);
//    }
//}
