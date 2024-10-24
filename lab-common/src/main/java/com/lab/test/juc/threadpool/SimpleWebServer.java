package com.lab.test.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: SimpleWebServer
 * Description: 模拟一个简单的Web服务器，接受请求并使用线程池进行处理
 *
 * @Author agility6
 * @Create 2024/9/27 16:32
 * @Version: 1.0
 */
public class SimpleWebServer {

    private static int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) {
        while (true) {
            Runnable request = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Request received and handled by " + Thread.currentThread().getName());
                }
            };

            exec.execute(request);
        }
    }

}
