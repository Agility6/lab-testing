package com.lab.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Test_HashMap
 * Description:
 *
 * @Author agility6
 * @Create 2024/10/5 21:32
 * @Version: 1.0
 */
public class Test_HashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        System.out.println(map.get(1));
    }
}
