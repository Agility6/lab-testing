package com.lab.test.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ThreadLocalNormalUsage01
 * Description: 1000个打印日期任务，使用线程池来执行
 *
 * @Author agility6
 * @Create 2024/9/27 22:41
 * @Version: 1.0
 */
public class ThreadLocalNormalUsage02 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new  ThreadLocalNormalUsage02().date(finalI);
                    System.out.println(date);
                }
            });
        }

        threadPool.shutdown();

    }


    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
