package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Permutations
 * Description:
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @author Administrator
 * @date 2023-5-22 14:25
 */
public class Permutations {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        int count = 0;
        backtrace(list, used, count, nums);
        return lists;

    }

    private void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
