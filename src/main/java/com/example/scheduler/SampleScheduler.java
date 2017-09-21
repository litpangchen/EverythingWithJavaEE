package com.example.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class SampleScheduler {

    //@Scheduled(fixedDelay = 1000)
    public void executeFixedDelay() {
        try {
            Thread.sleep(3000);
            System.out.println("Execute fixed delay method " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Scheduled(fixedRate = 1000)
    public void executeFixedRate() {
        try {
            Thread.sleep(5000);
            System.out.println("Execute fixed rate method " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
