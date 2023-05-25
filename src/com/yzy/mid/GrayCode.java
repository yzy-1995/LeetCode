package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GrayCode
 * Description:
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,3,2]
 * 解释：
 * [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 * - 00 和 01 有一位不同
 * - 01 和 11 有一位不同
 * - 11 和 10 有一位不同
 * - 10 和 00 有一位不同
 * [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 * - 00 和 10 有一位不同
 * - 10 和 11 有一位不同
 * - 11 和 01 有一位不同
 * - 01 和 00 有一位不同
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[0,1]
 *
 * @author Administrator
 * @date 2023-5-25 10:49
 */
public class GrayCode {
    /**
     * 当 n = 1 时，格雷码序列为 [0, 1]。
     * 当 n > 1 时，假设我们已经得到了 n - 1 位的格雷码序列，
     * 可以将其复制一份，并在前面添加 0，然后将原序列反转并在前面添加 1，
     * 最后将这两个序列合并起来即可得到 n 位的格雷码序列。
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        List<Integer> prev = grayCode(n - 1);
        result.addAll(prev);
        int mask = 1 << (n - 1);
        for (int i = prev.size() - 1; i >= 0; i--) {
            result.add(prev.get(i) | mask);
        }
        return result;
    }
}
