package com.lab.test.attend.config;

import com.lab.test.attend.context.AttendContext;
import com.lab.test.attend.util.AttendContextDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: KafkaConsumerConfig
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 22:24
 * @Version: 1.0
 */
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, AttendContext> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        String bootstrapServers = "localhost:9092";
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        String groupId = "group1";
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AttendContextDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, AttendContext>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AttendContext> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setBatchListener(true); // 开启批量消费
        return factory;
    }

}
