package com.yzy.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/07/26 00:16
 * @Description
 * 给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
 *
 * 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。l 和 r 下标都从 0 开始。
 * 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] + nums1[i] * p 。
 * 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
 * 请你返回一个数组，包含所有第三种操作类型的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,0,1], nums2 = [0,0,0], queries = [[1,1,1],[2,1,0],[3,0,0]]
 * 输出：[3]
 * 解释：第一个操作后 nums1 变为 [1,1,1] 。第二个操作后，nums2 变成 [1,1,1] ，所以第三个操作的答案为 3 。所以返回 [3] 。
 * 示例 2：
 *
 * 输入：nums1 = [1], nums2 = [5], queries = [[2,0,0],[3,0,0]]
 * 输出：[5]
 * 解释：第一个操作后，nums2 保持不变为 [5] ，所以第二个操作的答案是 5 。所以返回 [5] 。
 * @Version 1.0
 */
public class HandlingSumQueriesAfterUpdate {
    //tree[0]不用 tree中下标 1 代表原数组的0
    //左子树 区间为[l, r/2] 下标为2*i
    //右子树 区间为[r/2+1, r] 下标为2*i+1
    private Node[] tree;

    private long _build(int pos, int l, int r, int[] nums) {
        //判断是否超过了 nums范围
        if (l > nums.length) return 0;

        tree[pos] = new Node();
        tree[pos].l = l;
        tree[pos].r = r;
        if (l == r) {
            tree[pos].sum = nums[l - 1];
            return nums[l - 1];
        }

        //递归建立左子树 和 右子树
        int sPos = pos << 1;
        int tr = l + ((r-l) >> 1);
        tree[pos].sum = _build(sPos, l, tr, nums) + _build(sPos + 1, tr + 1, r, nums);
        return tree[pos].sum;
    }

    private long _update(int pos, int l, int r) {
        Node node = tree[pos];
        if (node.l == l && node.r == r) {
            //翻转操作 等于将 sum 数量修改为 r-l+1 - sum
            node.lazy ^= true;
            long old = node.sum;
            node.sum = (r - l + 1) - node.sum;
            return node.sum - old;
        }

        long totalOff = 0;
        //判断左子树是否有交集
        int t = pos << 1;
        Node lSon = tree[t];
        Node rSon = tree[t + 1];

        //传递lazy
        if(node.lazy) {
            _updateLazy(lSon);
            _updateLazy(rSon);
            node.lazy = false;
        }

        if (l <= lSon.r && l >= lSon.l) {
            totalOff = _update(t, l, Math.min(lSon.r, r));
        }

        //判断右子树是否有交集
        if (rSon != null && rSon.l <= r && rSon.r >= r) {
            totalOff += _update(t + 1, Math.max(rSon.l, l), r);
        }

        node.sum += totalOff;
        return totalOff;
    }

    private long _query(int pos, int l, int r) {
        Node node = tree[pos];
        if (node.l == l && node.r == r) return node.sum;

        int sonPos = pos << 1;
        Node lSon = tree[sonPos];
        Node rSon = tree[sonPos + 1];
        //不能完全覆盖时先处理lazy标记
        if (node.lazy) {
            //下推给两个孩子节点
            _updateLazy(lSon);
            _updateLazy(rSon);
            node.lazy = false;
        }

        //分段查询
        long totalSum = 0;
        if (l <= lSon.r && l >= lSon.l) {
            totalSum = _query(sonPos, l, lSon.r);
        }

        if (rSon != null && rSon.l <= r && rSon.r >= r) {
            totalSum += _query(sonPos + 1, rSon.l, r);
        }

        return totalSum;
    }

    private void _updateLazy(Node son) {
        if (son != null) {
            son.lazy ^= true;
            son.sum = (son.r - son.l + 1) - son.sum;
        }
    }

    /**
     * nums 下标从0开始
     */
    public void initSegmentTree(int[] nums) {
        //线段树的个数 应为 2*n 其中 n是2的幂次 且 >= nums.length 这样才能保证数组长度足够
        int n = 1;
        while (n < nums.length) n <<= 1;
        tree = new Node[n * 2];
        _build(1, 1, n, nums);
    }

    /**
     * 对原数组的 [l,r]区间元素 增加off
     */
    public void update(int l, int r) {
        _update(1, l + 1, r + 1);
    }

    /**
     * 查询原数组[l,r] 区间和
     */
    public long query(int l, int r) {
        return _query(1, l + 1, r + 1);
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        //每次模拟翻转 然后使用树状数组计算nums2都超时了
        //需要快速记录下nums1的操作 要快速查询和更新每次区间操作下1和0的个数
        //核心问题就是记录下当前nums1有多少 1， 不就是线段树了么。。。
        //[l,r]翻转操作等于 将该区间内 1的个数变为 r-l+1 - num_1(之前区间内的1的个数)


        List<Long> ls = new ArrayList<>();
        initSegmentTree(nums1);
        long sum = 0;
        for (int v : nums2) {
            sum += v;
        }

        for (int[] q : queries) {
            if (q[0] == 1) {
                int l = q[1];
                int r = q[2];
                update(l, r);
            } else if (q[0] == 2) {
                int p = q[1];
                if (p == 0) continue;
                //否则就是sum 加上  p * 1的个数
                sum += p * query(0, nums1.length - 1);

            } else {
                ls.add(sum);
            }
        }

        long[] res = new long[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            res[i] = ls.get(i);
        return res;
    }

    private class Node {
        private int l;
        private int r;
        //懒标记 用于快速完成修改操作 标识子节点未更新数据
        private boolean lazy;
        private long sum;
    }
}