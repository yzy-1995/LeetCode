package com.yzy.hard;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/11/17 00:00
 * @Description
 * 给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。
 *
 * 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
 *
 * 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
 * 输出：[6,10,7]
 * 解释：
 * 对于第 1 个查询：xi = 4 且 yi = 1 ，可以选择下标 j = 0 ，此时 nums1[j] >= 4 且 nums2[j] >= 1 。nums1[j] + nums2[j] 等于 6 ，可以证明 6 是可以获得的最大值。
 * 对于第 2 个查询：xi = 1 且 yi = 3 ，可以选择下标 j = 2 ，此时 nums1[j] >= 1 且 nums2[j] >= 3 。nums1[j] + nums2[j] 等于 10 ，可以证明 10 是可以获得的最大值。
 * 对于第 3 个查询：xi = 2 且 yi = 5 ，可以选择下标 j = 3 ，此时 nums1[j] >= 2 且 nums2[j] >= 5 。nums1[j] + nums2[j] 等于 7 ，可以证明 7 是可以获得的最大值。
 * 因此，我们返回 [6,10,7] 。
 * 示例 2：
 *
 * 输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
 * 输出：[9,9,9]
 * 解释：对于这个示例，我们可以选择下标 j = 2 ，该下标可以满足每个查询的限制。
 * 示例 3：
 *
 * 输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
 * 输出：[-1]
 * 解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不存在答案。
 * @Version 1.0
 */
public class maximumsumqueries {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[][] tmp1 = new int[nums1.length][2];
        int[][] tmp2 = new int[nums2.length][2];
        for(int i = 0; i < nums1.length; i++) {
            tmp1[i][0] = tmp2[i][0] = i;
            tmp1[i][1] = nums1[i];
            tmp2[i][1] = nums2[i];
        }
        Arrays.sort(tmp1, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(tmp2, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] pos = new int[nums1.length];
        for(int i = 0; i < tmp2.length; i++) {
            pos[tmp2[i][0]] = i;
        }
        int[][] tmp3 = new int[queries.length][3];
        for(int i = 0; i < queries.length; i++) {
            tmp3[i][0] = i;
            tmp3[i][1] = queries[i][0];
            tmp3[i][2] = queries[i][1];
        }
        Arrays.sort(tmp3, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int[] ans = new int[queries.length];
        int[] arr = new int[nums1.length + 2];
        int r = tmp1.length - 1;
        for(int i = tmp3.length - 1; i >= 0; i--) {
            int[] t = tmp3[i];
            while(r >= 0 && tmp1[r][1] >= t[1]) {
                int p = pos[tmp1[r][0]];
                int v = tmp1[r][1] + tmp2[p][1];
                set(arr, tmp2.length - p, v);
                r--;
            }
            int p = find(tmp2, t[2]);
            int m = query(arr, tmp2.length - p);
            if(m == 0) {
                ans[t[0]] = -1;
            } else {
                ans[t[0]] = m;
            }
        }
        return ans;
    }

    private int lowbit(int x) {
        return x & -x;
    }

    private void set(int[] arr, int x, int v) {
        while(x < arr.length) {
            arr[x] = Math.max(arr[x], v);
            x = x + lowbit(x);
        }
    }

    private int query(int[] arr, int x) {
        int ans = 0;
        while(x > 0) {
            ans = Math.max(ans, arr[x]);
            x = x - lowbit(x);
        }
        return ans;
    }

    private int find(int[][] t, int v) {
        int l = 0, r = t.length - 1, m;
        while(l < r) {
            m = l + (r - l) / 2;
            if(t[m][1] < v) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return t[l][1] >= v ? l : t.length;
    }
}