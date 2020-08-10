package com.async.controller;

import com.async.service.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/async")
    @ResponseBody
    public String  asyTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTask.task();
        asyncTask.task1();
        long end =  System.currentTimeMillis();
        System.out.println("主任务执行时间 " + (end - start));
        return "main task()";
    }
}
