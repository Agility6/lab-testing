package com.lab.test.attend.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab.test.attend.context.AttendContext;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * ClassName: AttendContextDeserializer
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 22:43
 * @Version: 1.0
 */
public class AttendContextDeserializer implements Deserializer<AttendContext> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public AttendContext deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, AttendContext.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize AttendContext", e);
        }
    }

    @Override
    public void close() {
    }
}

