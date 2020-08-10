package com.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程池大小
        poolTaskExecutor.setCorePoolSize(3);
        // 最大线程数
        poolTaskExecutor.setMaxPoolSize(5);
        // 队列容量
        poolTaskExecutor.setQueueCapacity(200);
        // 活跃时间
        poolTaskExecutor.setKeepAliveSeconds(60);
        // 线程名字前缀
        poolTaskExecutor.setThreadNamePrefix("taskExecutor-");
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return poolTaskExecutor;

    }

}
