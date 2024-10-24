package com.lab.test.juc.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ClassName: ParallelCalculation
 * Description:  并行计算
 *
 * @Author agility6
 * @Create 2024/9/27 16:36
 * @Version: 1.0
 */
public class ParallelCalculation {

    private static final int NTHREADS = 4;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) {

        Callable<Double> task = new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                // 模拟一些数值计算
                return Math.random() * 100;
            }
        };

        List<Future<Double>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(task));
        }

        for (Future<Double> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        exec.shutdown();
    }
}
