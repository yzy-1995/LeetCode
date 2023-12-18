package com.yzy.mid;

import java.util.TreeSet;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/09 10:42
 * @Description
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 *
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：22
 * 解释：
 * 22 是一个数值平衡数，因为：
 * - 数字 2 出现 2 次
 * 这也是严格大于 1 的最小数值平衡数。
 * 示例 2：
 *
 * 输入：n = 1000
 * 输出：1333
 * 解释：
 * 1333 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 1000 的最小数值平衡数。
 * 注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
 * 示例 3：
 *
 * 输入：n = 3000
 * 输出：3133
 * 解释：
 * 3133 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 3000 的最小数值平衡数。
 * @Version 1.0
 */
public class nextgreaternumericallybalancednumber {
    static final int MAX = 1224444;

    static final TreeSet<Integer> set = new TreeSet<>();

    static {
        outer: for (int i = 1; i <= MAX; i++) {
            int[] cnt = new int[10];
            int num = i;
            while (num != 0) {
                cnt[num % 10]++;
                num /=10;
            }
            for (int j = 0; j <= 9; j++) {
                if (cnt[j] != 0 && cnt[j] != j) {
                    continue outer;
                }
            }
            set.add(i);
        }
    }

    public int nextBeautifulNumber(int n) {
        return set.ceiling(n + 1);
    }
}