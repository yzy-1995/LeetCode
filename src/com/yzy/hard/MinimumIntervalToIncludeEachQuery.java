package com.yzy.hard;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/07/18 00:17
 * @Description
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
 *
 * 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
 *
 * 以数组形式返回对应查询的所有答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
 * 输出：[3,3,1,4]
 * 解释：查询处理如下：
 * - Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
 * - Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
 * - Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
 * 示例 2：
 *
 * 输入：intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
 * 输出：[2,-1,4,6]
 * 解释：查询处理如下：
 * - Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
 * - Query = 19：不存在包含 19 的区间，答案为 -1 。
 * - Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
 * - Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
 * @Version 1.0
 */
public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        SegTree tree = new SegTree(0, 10_000_000);
        for(int[] i : intervals) {
            set(tree, i[0], i[1], i[1] - i[0] + 1);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int k = query(tree, queries[i], queries[i]);
            if(k == 0x7fffffff) {
                ans[i] = -1;
            } else {
                ans[i] = k;
            }
        }
        return ans;
    }

    private void set(SegTree tree, int left, int right, int val) {
        if(left <= tree.left && right >= tree.right) {
            tree.val = Math.min(tree.val, val);
            tree.mark = Math.min(tree.mark, val);
            return;
        }
        int mid = tree.left + (tree.right - tree.left) / 2;
        if(tree.lc == null) {
            tree.lc = new SegTree(tree.left, mid);
        }
        if(tree.rc == null) {
            tree.rc = new SegTree(mid + 1, tree.right);
        }
        if(tree.mark < 0x7fffffff) {
            tree.lc.mark = Math.min(tree.lc.mark, tree.mark);
            tree.lc.val = Math.min(tree.lc.val, tree.mark);
            tree.rc.mark = Math.min(tree.rc.mark, tree.mark);
            tree.rc.val = Math.min(tree.rc.val, tree.mark);
            tree.mark = 0x7fffffff;
        }
        if(left <= mid) {
            set(tree.lc, left, right, val);
        }
        if(right > mid) {
            set(tree.rc, left, right, val);
        }
        tree.val = Math.min(tree.lc.val, tree.rc.val);
    }

    private int query(SegTree tree, int left, int right) {
        if(left <= tree.left && right >= tree.right) {
            return tree.val;
        }
        int mid = tree.left + (tree.right - tree.left) / 2;
        if(tree.lc == null) {
            tree.lc = new SegTree(tree.left, mid);
        }
        if(tree.rc == null) {
            tree.rc = new SegTree(mid + 1, tree.right);
        }
        if(tree.mark < 0x7fffffff) {
            tree.lc.mark = Math.min(tree.lc.mark, tree.mark);
            tree.lc.val = Math.min(tree.lc.val, tree.mark);
            tree.rc.mark = Math.min(tree.rc.mark, tree.mark);
            tree.rc.val = Math.min(tree.rc.val, tree.mark);
            tree.mark = 0x7fffffff;
        }
        int ans = 0x7fffffff;
        if(left <= mid) {
            ans = Math.min(ans, query(tree.lc, left, right));
        }
        if(right > mid) {
            ans = Math.min(ans, query(tree.rc, left, right));
        }
        return ans;
    }


    class SegTree {
        int left, right;
        int val, mark;
        SegTree lc, rc;
        public SegTree(int _l, int _r) {
            left = _l;
            right = _r;
            val = 0x7fffffff;
            mark = 0x7fffffff;
        }
    }
}