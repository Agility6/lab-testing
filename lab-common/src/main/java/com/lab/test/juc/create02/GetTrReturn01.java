package com.lab.test.juc.create02;

import java.util.concurrent.*;

/**
 * ClassName: GetTrReturn01
 * Description: 有返回值的Callable
 *
 * @Author agility6
 * @Create 2024/9/25 16:14
 * @Version: 1.0
 */
public class GetTrReturn01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 使用线程池来规定返回值
         */

        // 创建一个包含5个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 创建一个Callable接口对象
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello from Callable " + Thread.currentThread().getName();
            }
        };

        // 提交任务到ExecutorService执行，并获取Future对象
        Future[] futures = new Future[10];
        for (int i = 0; i < 10; i++) {
            futures[i] = executorService.submit(task);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(futures[i].get());
        }

        executorService.shutdown();

    }
}
