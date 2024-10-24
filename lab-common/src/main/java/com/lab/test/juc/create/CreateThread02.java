package com.lab.test.juc.create;

/**
 * ClassName: CreateThread02
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 15:46
 * @Version: 1.0
 */
public class CreateThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}
