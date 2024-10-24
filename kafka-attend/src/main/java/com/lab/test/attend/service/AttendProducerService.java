package com.lab.test.attend.service;

import com.lab.test.attend.context.AttendContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * ClassName: AttendProducerService
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 20:51
 * @Version: 1.0
 */
//@Service
@Slf4j
public class AttendProducerService {


    private final KafkaTemplate<String, AttendContext> kafkaTemplate;

    public AttendProducerService(KafkaTemplate<String, AttendContext> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, AttendContext o) {
        ListenableFuture<SendResult<String, AttendContext>> future = kafkaTemplate.send(topic, o);
        future.addCallback(result -> log.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }
}
