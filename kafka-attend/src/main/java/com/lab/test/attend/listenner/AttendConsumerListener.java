package com.lab.test.attend.listenner;

import com.lab.test.attend.context.AttendContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: AttendConsumerListener
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 22:30
 * @Version: 1.0
 */
//@Component
public class AttendConsumerListener {

    private static final int BATCH_SIZE = 500;

    @KafkaListener(topics = "${kafka.topic.my-topic}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(List<AttendContext> messages) {
        for (AttendContext message : messages) {
            System.out.println("消费者消费消息 -> " + message.toString());
        }
    }
}
