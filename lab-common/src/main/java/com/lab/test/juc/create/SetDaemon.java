package com.lab.test.juc.create;

/**
 * ClassName: SetDaemon
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 16:04
 * @Version: 1.0
 */
public class SetDaemon {
    public static void main(String[] args) {

        /**
         * 守护线程：就是服务其他的线程，像Java中的垃圾回收线程就是一个典型的守护线程
         * t1、t2是守护线程，t3是用户线程
         * 当t3运行完成后，t1、t2会自动退出
         */
        CreateThread02 ct = new CreateThread02();
        Thread t1 = new Thread(ct, "线程1");
        Thread t2 = new Thread(ct, "线程2");
        Thread t3 = new Thread(ct, "线程3");

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();


    }
}
