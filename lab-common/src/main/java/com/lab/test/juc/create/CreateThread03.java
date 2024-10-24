package com.lab.test.juc.create;

import java.util.concurrent.Callable;

/**
 * ClassName: Callable
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/25 15:51
 * @Version: 1.0
 */
public class CreateThread03 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World !";
    }
}
