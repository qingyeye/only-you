package com.only.you.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lc
 * @Title: TaskExecutorConfig
 * @ProjectName shengyapp
 * @Description: TODO
 * @date 2018/8/1416:23
 */
//声明这是一个配置类
//引入com.yitaijiyuan.bice.task下面的@service,@component,@repository,@controller注册为bean
//@ComponentScan("com.yitaijiyuan.bice.task")
//开启注解：开启异步支持
//配置类实现AsyncConfigurer接口并重写AsyncConfigurer方法，并返回一个ThreadPoolTaskExecutor
//这样我们就得到了一个基于线程池的TaskExecutor
@Configuration
@EnableAsync
@ComponentScan("com.only.you")
public class TaskExecutorConfig //implements AsyncConfigurer
{

    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorConfig.class);

    //配置类实现AsyncConfigurer接口并重写AsyncConfigurer方法，并返回一个ThreadPoolTaskExecutor
    //这样我们就得到了一个基于线程池的TaskExecutor
//    @Override
    @Bean(name = "myTaskAsyncPool")
    public Executor myTaskAsyncPool() {
//    public Executor getAsyncExecutor() {
        logger.info("TaskExecutorConfig1 - start" );
        // TODO Auto-generated method stub
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
        taskExecutor.setCorePoolSize(30);
        //连接池中保留的最大连接数。Default: 15 maxPoolSize
        taskExecutor.setMaxPoolSize(45);
        //queueCapacity 线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(300);
        //等待任务在关机时完成--表明等待所有线程执行完
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        taskExecutor.setAwaitTerminationSeconds(60 * 60);

        //配置线程池中的线程的名称前缀
        taskExecutor.setThreadNamePrefix("async1-service-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        taskExecutor.initialize();
        logger.info("TaskExecutorConfig1 - end" );
        return taskExecutor;
    }
    @Bean(name = "myTaskAsyncPool2")
    public Executor myTaskAsyncPool2() {
//    public Executor getAsyncExecutor() {
        logger.info("TaskExecutorConfig2 - start" );
        // TODO Auto-generated method stub
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
        taskExecutor.setCorePoolSize(20);
        //连接池中保留的最大连接数。Default: 15 maxPoolSize
        taskExecutor.setMaxPoolSize(30);
        //queueCapacity 线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(250);
        //等待任务在关机时完成--表明等待所有线程执行完
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        taskExecutor.setAwaitTerminationSeconds(60 * 60);

        //配置线程池中的线程的名称前缀
        taskExecutor.setThreadNamePrefix("async2-service-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        taskExecutor.initialize();
        logger.info("TaskExecutorConfig2 - end" );
        return taskExecutor;
    }
//    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        // TODO Auto-generated method stub
        return new MyAsyncExceptionHandler();
    }
    /**
     * 自定义异常处理类
     * @author hry
     *
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

        //手动处理捕获的异常
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            System.out.println("-------------》》》捕获线程异常信息");
            logger.info("Exception message - " + throwable.getMessage());
            logger.info("Method name - " + method.getName());
            logger.info("Method name - " + throwable.getCause());
//            logger.info("Method name - " +);
            throwable.printStackTrace();
            for (Object param : obj) {
                logger.info("Parameter value - " + param);
            }
        }

    }
}
