package com.lab.test.juc.create;

/**
 * ClassName: Sleep
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 15:59
 * @Version: 1.0
 */
public class Sleep {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始执行");
                try {
                    System.out.println("线程休眠1秒");
                    Thread.sleep(1000);
                    System.out.println("线程休眠结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程执行结束");
            }
        }).start();
    }
}
