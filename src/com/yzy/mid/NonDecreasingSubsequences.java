package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/29 00:11
 * @Description
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 *
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * @Version 1.0
 */
public class NonDecreasingSubsequences {
    private List<List<Integer>> ans = new LinkedList<>();
    private LinkedList<Integer> combination = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return ans;
    }

    private void backTracing (int[] num, int start) {

        // Every recursion round adds combination to ans if the size of that >= 2
        if (combination.size() >= 2) {
            ans.add(new ArrayList<>(combination));
        }

        // Level order remove duplicate
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = start; i < num.length; i++) {

            // If it is duplicate or less than the former number, jump the this loop
            if (!integerHashSet.add(num[i]) || (!combination.isEmpty() && num[i] < combination.getLast())) {
                continue;
            }

            combination.addLast(num[i]);
            backTracing(num, i + 1);
            combination.removeLast();
        }
    }
}