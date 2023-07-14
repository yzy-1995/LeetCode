package com.yzy.simple;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.simple
 * @Date 2023/07/12 22:25
 * @Description 给你两个整数 num 和 t 。
 * <p>
 * 如果整数 x 可以在执行下述操作不超过 t 次的情况下变为与 num 相等，则称其为 可达成数字 ：
 * <p>
 * 每次操作将 x 的值增加或减少 1 ，同时可以选择将 num 的值增加或减少 1 。
 * 返回所有可达成数字中的最大值。可以证明至少存在一个可达成数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 4, t = 1
 * 输出：6
 * 解释：最大可达成数字是 x = 6 ，执行下述操作可以使其等于 num ：
 * - x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。
 * 可以证明不存在大于 6 的可达成数字。
 * 示例 2：
 * <p>
 * 输入：num = 3, t = 2
 * 输出：7
 * 解释：最大的可达成数字是 x = 7 ，执行下述操作可以使其等于 num ：
 * - x 减少 1 ，同时 num 增加 1 。此时，x = 6 且 num = 4 。
 * - x 减少 1 ，同时 num 增加 1 。此时，x = 5 且 num = 5 。
 * 可以证明不存在大于 7 的可达成数字。
 * @Version 1.0
 */
public class FindTheMaximumAchievableNumber {
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }
}