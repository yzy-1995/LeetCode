package com.yzy.mid;

/**
 * ClassName: FindTheDuplicateNumber
 * Description:
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 * @author Administrator
 * @date 2023-6-21 8:34
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int[] res = new int[nums.length];
        for (int num : nums) {
            res[num]++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
