package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode1018
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 *
 * 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 *
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：[false,false,false]
 * @author yzy15
 * @date 2023/04/25 20:03
 **/
public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {

    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int currentNum = 0;

        for (int num : nums) {
            currentNum = (currentNum * 2 + num) % 5;
            answer.add(currentNum % 5 == 0);
        }

        return answer;
    }
}
