package com.cybage.asyncexample.contoller;

import com.cybage.asyncexample.service.AsyncNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class AsyncNotificationContoller {
    @Autowired
    AsyncNotificationService service;


    @GetMapping("/sendNotification")
    public @ResponseBody String sendNotification(@RequestParam String mobile){
        System.out.println("Send Msg Method Executing... ");
        service.sendTextMessage(mobile);


        return "Message Send Successfully :"+Thread.currentThread().getName();

    }
}
