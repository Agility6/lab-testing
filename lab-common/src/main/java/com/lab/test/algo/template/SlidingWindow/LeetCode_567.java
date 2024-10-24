package com.lab.test.algo.template.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode_567
 * Description:
 *
 * @Author agility6
 * @Create 2024/10/4 15:31
 * @Version: 1.0
 */
public class LeetCode_567 {

    public boolean checkInclusion(String t, String s) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int cnt = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 进行窗口内数据的更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 当前字符的个数等于所需要的个数，cnt++
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    cnt++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                if (cnt == need.size()) return true;
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    // 当前字符的个数等于所需的个数 cnt--
                    // 因为这时候left已经是--了
                    if (window.get(d).intValue() == need.get(d).intValue()) cnt--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
