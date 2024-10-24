package com.lab.test.juc.create02;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.*;

/**
 * ClassName: FutureTask01
 * Description: 异步执行一个计算并在稍后的某个时间点获取其结果
 *
 * @Author agility6
 * @Create 2024/9/25 16:38
 * @Version: 1.0
 */
public class FutureTask01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Callable<Integer>[] tasks = new Callable[5];
        for (int i = 0; i < tasks.length; i++) {
            final int index = i;
            tasks[i] = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    ThreadUtil.sleep(index + 1, TimeUnit.SECONDS);
                    return (index + 1) * 100;
                }
            };
        }

        // 将Callable包装为FutureTask并提交到线程池
        FutureTask<Integer>[] futureTasks = new FutureTask[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            futureTasks[i] = new FutureTask<>(tasks[i]);
            executorService.submit(futureTasks[i]);
        }

        for (int i = 0; i < futureTasks.length; i++) {
            System.out.println("Result of futureTask " + i + ": " + futureTasks[i].get());
        }

        executorService.shutdown();

    }
}
