package com.lab.test.attend.controller;

import com.lab.test.attend.service.AttendProducerService;
import com.lab.test.attend.context.AttendContext;
import com.lab.test.core.response.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * ClassName: AttendController
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/21 23:49
 * @Version: 1.0
 */
@RestController
public class AttendController {

//    @Value("${kafka.topic.my-topic}")
//    private String myTopic;

//    private final AttendProducerService producer;

//    public AttendController(AttendProducerService producer) {
//        this.producer = producer;
//    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("hello");
    }

//    @PostMapping("attend")
//    public R attend(@RequestParam("userId") String userId, @RequestParam("attendDate") Date attendDate) {
//        AttendContext context = new AttendContext();
//        context.setUserId(userId);
//        context.setAttendDate(attendDate);
//        try {
//            producer.sendMessage(myTopic, context);
//            return R.success();
//        } catch (Exception e) {
//            return R.fail();
//        }
//    }

}
