package com.cybage.asyncexample.util;

import com.cybage.asyncexample.model.Employee;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
@Component
public class SendNotification {
    //Send notification to all employee
    @Async   //When use @Async then 1.method should public 2.Caller and @Async method should not in same class.
    public void sendNotificationSMS(List<Employee> emp) {
        for (Employee e1 : emp
        ) {
            try {

                System.err.println("SMS Notification send to :" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(20);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //trying to create manual exception which is throw  exception msg
            System.out.println(10/0);
        }
    }
}
