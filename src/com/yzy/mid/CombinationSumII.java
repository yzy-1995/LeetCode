package com.yzy.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: CombinationSumII
 * Description:
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @author Administrator
 * @date 2023-5-22 11:27
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList();
    List<Integer> path = new ArrayList();

    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }

    private void backtrack(int i, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length && sum + candidates[j] <= target; ++j) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            path.add(candidates[j]);
            sum += candidates[j];
            backtrack(j + 1, candidates, target);
            sum -= candidates[j];
            path.remove(path.size() - 1);
        }
    }
}
