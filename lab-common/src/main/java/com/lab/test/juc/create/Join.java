package com.lab.test.juc.create;

/**
 * ClassName: Join
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 16:00
 * @Version: 1.0
 */
public class Join {
    public static void main(String[] args) {
        CreateThread02 thread02 = new CreateThread02();
        Thread thread = new Thread(thread02, "线程1");
        Thread thread1 = new Thread(thread02, "线程2");
        Thread thread2 = new Thread(thread02, "线程3");

        thread.start();
        try {
            thread.join(); // 等待t1执行完才会轮到t2、t3抢
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.start();
        thread2.start();
    }
}
