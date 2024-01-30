package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/30 22:11
 * @Description
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 *
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 *
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
 *
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
 * 输出：true
 * 解释：你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 。
 * 这两个子数组是不相交的，因为它们没有任何共同的元素。
 * 示例 2：
 *
 * 输入：groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
 * 输出：false
 * 解释：选择子数组 [1,2,3,4,10,-2] 和 [1,2,3,4,10,-2] 是不正确的，因为它们出现的顺序与 groups 中顺序不同。
 * [10,-2] 必须出现在 [1,2,3,4] 之前。
 * 示例 3：
 *
 * 输入：groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
 * 输出：false
 * 解释：选择子数组 [7,7,1,2,3,4,7,7] 和 [7,7,1,2,3,4,7,7] 是不正确的，因为它们不是不相交子数组。
 * 它们有一个共同的元素 nums[4] （下标从 0 开始）。
 * @Version 1.0
 */
public class formarraybyconcatenatingsubarraysofanotherarray {
    public boolean canChoose(int[][] groups, int[] nums) {
        int len = nums.length;
        int index = 0;
        int numIndex = 0;
        while (numIndex < len) {
            int[] temp = groups[index];
            int i = 0;
            //由于存在temp在nums中匹配失败的可能，所以需要tempIndex来存储下标
            int tempIndex = numIndex;
            //查找temp第一个元素在nums的位置
            while (tempIndex < len) {
                if (nums[tempIndex] == temp[i]) break;
                tempIndex++;
            }
            //如果tempIndex大于len则匹配失败，直接结束
            if (tempIndex >= len) break;
            while (i < temp.length) {
                //判断temp与nums中以numIndex下标开始的子数组是否匹配
                if (tempIndex >= len || nums[tempIndex] != temp[i]) break;
                tempIndex++;
                i++;
            }
            if (i >= temp.length) {
                index++;
                //temp在nums中匹配成功，更新numIndex的下标
                numIndex = tempIndex;
            } else {
                //匹配失败，numIndex++
                numIndex++;
            }
            //判断groups中的所有数组已经遍历完毕
            if (index >= groups.length) return true;
        }
        return false;
    }
}