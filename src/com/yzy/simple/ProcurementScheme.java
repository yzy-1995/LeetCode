package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: ProcurementScheme
 * Description:
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，
 * 假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 *
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * 示例 1：
 *
 * 输入：nums = [2,5,3,5], target = 6
 *
 * 输出：1
 *
 * 解释：预算内仅能购买 nums[0] 与 nums[2]。
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,1,9], target = 10
 *
 * 输出：4
 *
 * 解释：符合预算的采购方案如下： nums[0] + nums[1] = 4 nums[0] + nums[2] = 3 nums[1] + nums[2] = 3 nums[2] + nums[3] = 10
 *
 * @author Administrator
 * @date 2023-3-27 15:25
 */
public class ProcurementScheme {
    public static void main(String[] args) {
    int nums[]={2,2,1,9};
        ProcurementScheme procurementScheme = new ProcurementScheme();
        System.out.println(procurementScheme.purchasePlans(nums, 10));
    }
    public int purchasePlans(int[] nums, int target) {
        int mod = (int) (1e9 + 7);
        int result = 0 ;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left<right){
        if (nums[left]+nums[right]>target){
            right--;
        }else{
            result += right-left;
            left++;
        }
        result %= mod;
        }
        return result%mod;
    }
}
