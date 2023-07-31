package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/01 00:08
 * @Description
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 *
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 *
 * 实现 Solution 类：
 *
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 *
 *
 * 示例：
 *
 * 输入
 * ["Solution", "flip", "flip", "flip", "reset", "flip"]
 * [[3, 1], [], [], [], [], []]
 * 输出
 * [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]
 *
 * 解释
 * Solution solution = new Solution(3, 1);
 * solution.flip();  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * solution.flip();  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
 * solution.flip();  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
 * solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
 * solution.flip();  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * @Version 1.0
 */
public class RandomFlipMatrix {
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int z;
    int n;
    int total;

    public RandomFlipMatrix(int m, int n) {
        this.n = n;
        total = m*n;
        z = total;
    }

    public int[] flip() {
        int i = random.nextInt(z);
        int k = map.getOrDefault(i, i); // 如果map中找不到则说明还没被访问过，返回初始化的值
        int swap = map.getOrDefault(z-1, z-1); // arr[z-1]
        // 交换
        map.put(i, swap);
        map.put(z-1, k);
        --z;
        return new int[]{k/n, k%n};
    }

    public void reset() {
        z = total;
        map.clear();
    }
}