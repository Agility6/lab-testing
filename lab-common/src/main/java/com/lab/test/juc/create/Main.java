package com.lab.test.juc.create;

import java.util.concurrent.FutureTask;

/**
 * ClassName: Main
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 15:45
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
//        CreateThread01 thread01 = new CreateThread01();
//        CreateThread01 thread02 = new CreateThread01();
//        thread01.setName("线程1");
//        thread02.setName("线程2");
//        thread01.start();
//        thread02.start();

//        CreateThread02 thread01 = new CreateThread02();
//        Thread t1 = new Thread(thread01, "线程1");
//        Thread t2 = new Thread(thread01, "线程2");
//        Thread t3 = new Thread(thread01, "线程3");
//        t1.start();
//        t2.start();
//        t3.start();

        FutureTask<String> task = new FutureTask<>(new CreateThread03());
        new Thread(task).start();
        try {
            String result = task.get();
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
