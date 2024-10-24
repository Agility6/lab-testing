package com.lab.test.juc.threadlocal;

import lombok.extern.java.Log;

/**
 * ClassName: ThreadLocalNPE
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/27 23:06
 * @Version: 1.0
 */
public class ThreadLocalNPE {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
    }

    /**
     * 注意这里的返回值是包装类型还是基本类型
     * @return
     */
    public Long get() {
        return longThreadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalNPE threadLocalNPE = new ThreadLocalNPE();
        System.out.println(threadLocalNPE.get());
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalNPE.set();
                System.out.println(threadLocalNPE.get());
            }
        });
        thread1.start();
    }
}
