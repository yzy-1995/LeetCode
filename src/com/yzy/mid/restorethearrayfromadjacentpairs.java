package com.yzy.mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/27 23:04
 * @Description
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 *
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 *
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 * @Version 1.0
 */
public class restorethearrayfromadjacentpairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        int[] nums = new int[n];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            if (!map.containsKey(adjacentPairs[i][0])) {
                Set<Integer> set = new HashSet<>();
                set.add(adjacentPairs[i][1]);
                map.put(adjacentPairs[i][0], set);
            }else {
                Set<Integer> set = map.get(adjacentPairs[i][0]);
                set.add(adjacentPairs[i][1]);
                map.put(adjacentPairs[i][0], set);
            }
            if (!map.containsKey(adjacentPairs[i][1])) {
                Set<Integer> set = new HashSet<>();
                set.add(adjacentPairs[i][0]);
                map.put(adjacentPairs[i][1], set);
            }else {
                Set<Integer> set = map.get(adjacentPairs[i][1]);
                set.add(adjacentPairs[i][0]);
                map.put(adjacentPairs[i][1], set);
            }
        }
        int j = 0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            int temp = adjacentPairs[i][0];
            if (map.get(temp).size() == 1) {
                nums[j] = temp;
                j++;
                while (!map.isEmpty()) {
                    nums[j] = map.get(temp).iterator().next();
                    map.get(nums[j]).remove(temp);
                    if (map.get(nums[j]).size() == 0) {
                        map.remove(nums[j]);
                    }
                    map.remove(temp);
                    temp = nums[j];
                    j++;
                }
                break;
            }
            temp = adjacentPairs[i][1];
            if (map.get(temp).size() == 1) {
                nums[j] = temp;
                j++;
                while (!map.isEmpty()) {
                    nums[j] = map.get(temp).iterator().next();
                    map.get(nums[j]).remove(temp);
                    if (map.get(nums[j]).size() == 0) {
                        map.remove(nums[j]);
                    }
                    map.remove(temp);
                    temp = nums[j];
                    j++;
                }
                break;
            }
        }
        return nums;
    }
}