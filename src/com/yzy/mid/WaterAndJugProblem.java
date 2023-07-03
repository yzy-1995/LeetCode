package com.yzy.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/01 12:47
 * @Description 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * <p>
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * <p>
 * 你可以：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
 * 输出: true
 * 解释：来自著名的 "Die Hard"
 * 示例 2:
 * <p>
 * 输入: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
 * 输出: true
 * @Version 1.0
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        int n = jug1Capacity + jug2Capacity;
        jug1Capacity = Math.min(jug1Capacity, jug2Capacity);
        jug2Capacity = n - jug1Capacity;
        return dfs(jug1Capacity, jug2Capacity, targetCapacity);
    }

    Set<Integer> set = new HashSet<>();

    private boolean dfs(int a, int b, int t) {
        if (a == 0 || b == 0) return false;
        int k = b % a;
        if (set.contains(k)) return false;
        if ((t - k) % a == 0 || (t - k) % b == 0 || (t - (a - k)) % a == 0 || (t - (a - k) % b == 0)) return true;
        set.add(k);
        return dfs(k, b, t) || dfs(k, a, t);
    }
}