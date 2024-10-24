package com.lab.test.juc.create;

/**
 * ClassName: CreateThread01
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 15:44
 * @Version: 1.0
 */
public class CreateThread01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " -> " + i);
        }
    }
}
