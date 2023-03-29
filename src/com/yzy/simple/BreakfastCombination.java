package com.yzy.simple;

import java.util.Arrays;

/**
 * ClassName: BreakfastCombination
 * Description:
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，
 * 且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，
 * 如：计算初始结果为：1000000008，请返回 1
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 * 输出：6
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 *
 * @author Administrator
 * @date 2023-3-27 14:08
 */
public class BreakfastCombination {
    public static void main(String[] args) {
        int[] staple = {10, 20, 5}, drinks = {5, 5, 2};
        BreakfastCombination breakfastCombination = new BreakfastCombination();
        System.out.println(breakfastCombination.breakfastNumber(staple, drinks, 15));
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int count = 0;
        int mod = (int) (1e9 + 7);
        int right = drinks.length - 1;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] > x) {
                break;
            }
            int result = getNum(drinks, x - staple[i], right);
            count = (count + result) % mod;
            right = result - 1;
        }
        return count;
    }

    private int getNum(int[] drinks, int limit, int right) {
        int left = 0;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (drinks[mid] <= limit) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans +1 ;
    }
}
