package com.lab.test.algo.dp;

/**
 * ClassName: Knapsack_01
 * Description:
 *
 * @Author agility6
 * @Create 2024/9/27 10:52
 * @Version: 1.0
 */
public class Knapsack_01 {
    /**
     * 0-1背包：有n个物品，第i个物品的体积为w[i]，价值为v[i]，背包的容量为C
     * 求解将哪些物品装入背包可使价值总和最大。
     * <p>
     * 选和不选的问题
     * <p>
     * 回溯三问
     * 1. 当前操作？枚举第i个物品选或不选：
     * 不选，剩余容量不变；选，剩余容量减少w[i]
     * <p>
     * 2. 子问题：在剩余容量为c时，
     * 从前i个物品中得到的最大价值和
     * <p>
     * 3. 下一个子问题？分类讨论：
     * 不选：在剩余容量为c时
     * 从前i-1个物品中得到的最大价值和
     * 选：在剩余容量为c-w[i]时
     * 从前i-1个物品中得到的最大价值和
     * <p>
     * dfs(i, c) = max(dfs(i - 1, c), dfs(i - 1, c - w[i]) + v[i])
     */

    int[] w = new int[10]; // 体积
    int[] v = new int[10]; // 价值
    int dfs(int i, int c) {
        if (i < 0) return 0;
        if (c < w[i]) return dfs(i - 1, c);
        return Math.max(dfs(i - 1, c), dfs(i - 1, c - w[i]) + v[i]);
    }
}
