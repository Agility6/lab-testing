package com.lab.test.algo.template.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode_76
 * Description:
 *
 * @Author agility6
 * @Create 2024/10/5 16:33
 * @Version: 1.0
 */
public class LeetCode_76 {

    public static void main(String[] args) {
        System.out.println(minWindow3("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> w = new HashMap<>();
        Map<Character, Integer> n = new HashMap<>();

        for (char c : t.toCharArray()) {
            n.put(c, n.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int cnt = 0; // 滑动
        int sum = Integer.MAX_VALUE;
        String ans = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (n.containsKey(c)) {
                w.put(c, w.getOrDefault(c, 0) + 1);
                if (w.get(c).equals(n.get(c))) cnt++;
            }

            while (cnt == t.length()) {
                if (right - left + 1 <= sum) {
                    ans = s.substring(left, right);
                }
                sum = Math.min(sum, right - left + 1);
                char d = s.charAt(left);
                left++;
                if (n.containsKey(d)) {
                    if (w.get(d).equals(n.get(d))) cnt--;
                    w.put(d, w.getOrDefault(d, 0) - 1);
                }
            }
        }

        return ans;

    }


    public static String minWindow2(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {

                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static String minWindow3(String s, String t) {
        Map<Character, Integer> w = new HashMap<>();
        Map<Character, Integer> n = new HashMap<>();

        for (char c : t.toCharArray()) {
            n.put(c, n.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        int start = 0;
        int e = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (n.containsKey(c)) {
                w.put(c, w.getOrDefault(c, 0) + 1);
                if (w.get(c).equals(n.get(c))) cnt++;
            }

            while (cnt == n.size()) {;
                if (right - left + 1 < len) {
                    start = left;
                    e = right;
                }
                len = Math.min(len, right - left + 1);
                char d = s.charAt(left);
                left++;
                if (n.containsKey(d)) {
                    if (w.get(d).equals(n.get(d))) cnt--;
                    w.put(d, w.getOrDefault(d, 0) + 1);
                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, e);
    }
}
