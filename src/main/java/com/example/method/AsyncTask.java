package com.example.method;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@EnableAsync
@Component
public class AsyncTask {

    @Async
    public void someHeavyBackgroundTask(final int sleepTime) {
        try {
            Thread.sleep(sleepTime * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<String> someHeavyBackgroundTaskWithReturnValue(final int sleepTime) {
        try {
            Thread.sleep(sleepTime * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("done");
    }

    public void printLog() {
        System.out.println("Job task on " + System.currentTimeMillis());
    }
}
