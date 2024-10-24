package com.lab.test.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: ThreadLocalNormalUsage00
 * Description: 两个线程打印日期
 *
 * @Author agility6
 * @Create 2024/9/27 22:41
 * @Version: 1.0
 */
public class ThreadLocalNormalUsage00 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10);
                System.out.println(date);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalNormalUsage00().date(10400);
                System.out.println(date);
            }
        }).start();

    }




    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
