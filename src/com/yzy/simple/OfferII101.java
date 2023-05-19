package com.yzy.simple;

/**
 * ClassName: OfferII101
 * Description:
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：nums 不可以分为和相等的两部分
 *
 * @author Administrator
 * @date 2023-5-19 16:10
 */
public class OfferII101 {
    public boolean canPartition(int[] nums) {
        int m = 0;
        for (int num : nums) m += num;
        if (m % 2 != 0) return false;
        m /= 2;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int x : nums) {
            for (int j = m; j >= x; j--) {
                f[j] |= f[j - x];
            }
        }
        return f[m];
    }
}
