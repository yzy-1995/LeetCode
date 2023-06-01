package com.yzy.mid;

import java.util.List;

/**
 * ClassName: Triangle
 * Description:
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
 * 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * @author Administrator
 * @date 2023-5-30 10:19
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] arr = new int[]{triangle.get(0).get(0)};
        for (int i = 1; i < triangle.size(); i++) {
            int[] a = new int[i + 1];
            a[0] = arr[0] + triangle.get(i).get(0);
            a[i] = arr[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                a[j] = triangle.get(i).get(j) + Math.min(arr[j - 1], arr[j]);
            }
            arr = a;
        }
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }
}
