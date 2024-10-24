package com.lab.test.attend;

import com.lab.test.attend.service.AttendProducerService;
import com.lab.test.attend.context.AttendContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * ClassName: AttendControllerTest
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/23 21:19
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AttendApplication.class)
public class AttendControllerTest {

    @Autowired
    private AttendProducerService producerService;

    @Test
    public void testSendMessageSingle(){
        AttendContext context = new AttendContext();
        context.setUserId("1");
        context.setAttendDate(new Date());
        producerService.sendMessage("my-topic", context);
    }

    @Test
    public void testSendMessage(){
        for (int i = 0; i < 100000; i++) {
            AttendContext context = new AttendContext();
            context.setUserId(String.valueOf(i));
            context.setAttendDate(new Date());
            producerService.sendMessage("my-topic", context);
        }
    }
}
