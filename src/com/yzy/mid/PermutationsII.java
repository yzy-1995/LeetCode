package com.yzy.mid;

import java.util.*;

/**
 * ClassName: PermutationsII
 * Description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author Administrator
 * @date 2023-5-22 14:44
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int n = output.size();
        dfs(n, res, output, 0);
        return new ArrayList<>(res);
    }

    private static void dfs(int n, Set<List<Integer>> res, List<Integer> output, int i) {
        if (i == n) {
            res.add(new ArrayList<>(output));
        }
        for (int j = i; j < n; j++) {
            Collections.swap(output, j, i);
            dfs(n, res, output, i + 1);
            Collections.swap(output, j, i);
        }
    }
}
