package com.yzy.mid;

import java.util.Stack;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/15 00:20
 * @Description
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * @Version 1.0
 */
public class maximumwidthramp {
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || nums[stack.peek()] > nums[i])
                stack.push(i);
        }
        for(int i = nums.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()])
                maxWidth = Math.max(maxWidth, i - stack.pop());
        }
        return maxWidth;
    }
}