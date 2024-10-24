package com.lab.test.juc.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: ThreadLocalNormalUsage01
 * Description: 10个线程打印日期
 *
 * @Author agility6
 * @Create 2024/9/27 22:41
 * @Version: 1.0
 */
public class ThreadLocalNormalUsage01 {
    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String date = new ThreadLocalNormalUsage01().date(finalI);
                    System.out.println(date);
                }
            }).start();

        }

    }




    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

}
