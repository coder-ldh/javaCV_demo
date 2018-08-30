package com.ldh.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ldh
 */
public class ThreadFactoryConfg {

   volatile static LinkedBlockingDeque<Runnable> workQueue=new LinkedBlockingDeque<>(3);

   volatile static ThreadPoolExecutor threadPoolExecutor;

  public static  synchronized  ThreadPoolExecutor instance(){
      //指定3个长度的工作队列
      //指定线程池参数：核心线程数，线程池最大线程数量，活跃时间，工作队列
      threadPoolExecutor=new ThreadPoolExecutor(4, 7, 90,
          TimeUnit.SECONDS, workQueue);
      return  threadPoolExecutor;
    }
}