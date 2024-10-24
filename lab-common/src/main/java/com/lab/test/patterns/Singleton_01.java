package com.lab.test.patterns;

import java.security.SignedObject;

/**
 * ClassName: Singleton_01
 * Description:
 *
 * @Author agility6
 * @Create 2024/10/7 13:51
 * @Version: 1.0
 */
public class Singleton_01 {

    // 双重校验锁实现对象单利（线程安全）
    /**
     * uniqueInstance = new Singleton_01();
     * 1. 为uniqueInstance分配内存
     * 2. 初始化uniqueInstance
     * 3. 将uniqueInstance指向分配的内存地址
     */
    private volatile static Singleton_01 uniqueInstance;

    public Singleton_01() {
    }

    public static Singleton_01 getUniqueInstance() {
        if (uniqueInstance == null) {
            // 加锁
            synchronized(Singleton_01.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton_01();
                }
            }
        }
        return uniqueInstance;
    }
}
