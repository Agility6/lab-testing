package com.lab.test.juc.create02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: GetTrReturn02
 * Description: 使用Runnable的方式
 *
 * 可以看到，使用 Runnable 的方式要比 Callable 的方式简单一些，
 * 但是 Callable 的方式可以获取执行结果，这是 Runnable 做不到的。
 *
 * @Author agility6
 * @Create 2024/9/25 16:24
 * @Version: 1.0
 */
public class GetTrReturn02 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Runnable " + Thread.currentThread().getName());
            }
        };

        // 提交任务到ExecutorService执行
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
