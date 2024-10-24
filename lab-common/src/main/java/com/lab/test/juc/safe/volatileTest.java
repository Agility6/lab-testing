package com.lab.test.juc.safe;

/**
 * ClassName: volatileTest
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 17:36
 * @Version: 1.0
 */
public class volatileTest {
    static int i = 50;
    static int j = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                i = 100;
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                j = i;
                System.out.println(j);
            }
        });

        thread.start();
        thread1.start();
    }
}
