package com.lab.test.juc.create;

import javax.swing.*;

/**
 * ClassName: YieId
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 16:08
 * @Version: 1.0
 */
public class YieId {
    public static void main(String[] args) {
        /**
         * yield()方法：暂停当前正在执行的线程对象，并执行其他线程
         */

        Thread thread1 = new Thread(YieId::printNumber, "线程1");
        Thread thread2 = new Thread(YieId::printNumber, "线程2");
        thread1.start();
        thread2.start();
    }

    private static void printNumber() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "让出CPU执行权");
                Thread.yield();
            }
        }
    }
}
