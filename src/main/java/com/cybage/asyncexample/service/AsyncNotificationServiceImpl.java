package com.cybage.asyncexample.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncNotificationServiceImpl implements  AsyncNotificationService{

    @Override
    @Async
    public void sendTextMessage(String mobile) {
//Dummy logic to call 3rd party services for send msg
        sleep(2);
        System.out.println("Third party call to send msg :"+Thread.currentThread().getName());
        System.out.println(10/0);



    }

    private void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
