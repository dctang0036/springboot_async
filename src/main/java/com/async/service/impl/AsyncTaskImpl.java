package com.async.service.impl;

import com.async.service.AsyncTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskImpl implements AsyncTask {

    @Override
    @Async
    public void task() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("异步任务task执行时间 " + (end - start));
    }

    @Override
    @Async
    public void task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("异步任务task1执行时间 " + (end - start));
    }
}
