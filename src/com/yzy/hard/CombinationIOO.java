package com.yzy.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ComibaiIOO
 * Description:
 * 从1到100，一个数，两个数，三个数或者多个数一组，取任意组合，
 * 对组合里的数进行求和为100的组合举例:[100][1.99]1[1,2,97] [5,6,7,8,9,11,12,13,14,15]
 * @author Administrator
 * @date 2023-4-14 15:14
 */
public class CombinationIOO {
    public static void main(String[] args) {
        int target = 100;
        int[] candidates = new int[100];
        for (int i = 1; i <= 100; i++) {
            candidates[i - 1] = i;
        }

        List<List<Integer>> result = combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(result, combination, candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                backtrack(result, combination, candidates, target - candidates[i], i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static int combinationSumDP(int[] candidates, int target) {
        int n = candidates.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= candidates[i - 1]) {
                    dp[i][j] += dp[i - 1][j - candidates[i - 1]];
                }
            }
        }

        return dp[n][target];
    }


}
