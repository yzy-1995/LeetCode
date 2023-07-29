package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/29 00:13
 * @Description
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 * @Version 1.0
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        // target + sum(nums)必须是偶数，否则无解
        // Math.abs(target) <= sum才有解
        if(((sum + target) & 1) == 1 || Math.abs(target) > sum){
            return 0;
        }
        int size = (sum + target) / 2;
        // 定义二维数组dp，其中dp[i][j]表示在数组下标为0...i的元素中任选元素，使得这些元素之和等于j的方案数
        int[][] dp = new int[len][size + 1];
        // 对dp[0][j]的初始化：除dp[0][0]和dp[0][nums[0]]外全部初始化为0
        // dp[0][0] = 1：nums[0]不为0时，此时dp[0][0]和dp[0][nums[0]]不重合,只有不选nums[0]，其总和为0
        // dp[0][0] = 2：nums[0]为0时，此时dp[0][0]和dp[0][nums[0]]重合，选或者不选nums[0]，其总和都为0
        if(nums[0] <= size ){
            dp[0][nums[0]] = 1;
        }
        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }
        // 对dp[i][0]的初始化，可以放在下面整个dp的递推代码中
        for(int i = 1; i < len; i++){
            if(nums[i] == 0){
                // 当nums[i]为0时，选或者不选nums[i]都可以使总和为0，即dp[i][0] = dp[i - 1][0] + dp[i - 1][0 - nums[i]] = 2 * dp[i -1][0]
                dp[i][0] = 2 * dp[i -1][0];
            }else{
                // 当nums[i]不为0时，只有不选nums[i]才可以使总和为0
                dp[i][0] = dp[i - 1][0];
            }
        }
        // dp[i][j]递推：由于初始化时都将i = 0和j = 0的情况已经赋值，所以直接从i = 1和j = 1开始
        // 完全可以将上面对dp[i][0]的初始化放在此处，只需要将j从0开始
        for(int i = 1; i < len; i++){
            for(int j = 1; j <= size; j++){
                if(j >= nums[i]){
                    dp[i][j] = dp[i -1][j] + dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][size];
    }
}