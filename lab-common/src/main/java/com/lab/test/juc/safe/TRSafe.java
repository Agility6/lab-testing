package com.lab.test.juc.safe;

/**
 * ClassName: TRSafe
 * Description:  多线程环境出现的线程不安全情况，原子性
 *
 * @Author agility6
 * @Create 2024/9/25 17:30
 * @Version: 1.0
 */
public class TRSafe {

    private static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 2;
        int numIncrementsPerThread = 100000;

        Thread[] threads = new Thread[numThreads];


        // 两个线程同时对i进行100000次累加
        for (int j = 0; j < numThreads; j++) {
            threads[j] = new Thread(() -> {
                for (int k = 0; k < numIncrementsPerThread; k++) {
                    i++;
                }
            });
            // 启动线程
            threads[j].start();
        }

        // 等待所有线程执行完毕
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("final value of i = " + i);
        System.out.println("Expected value of i = " + numThreads * numIncrementsPerThread);
    }
}
