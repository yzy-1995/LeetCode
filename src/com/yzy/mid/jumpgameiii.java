package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/20 00:15
 * @Description
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 *
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * @Version 1.0
 */
public class jumpgameiii {
    private boolean res = false;

    public boolean canReach(int[] arr, int start) {
        dfs(start, new int[arr.length], arr);
        return res;
    }
    private void dfs(int i, int[] uniques, int[] arr) {
        if (res == true)
            return;
        if (i < 0 || i >= arr.length)
            return;
        else {
            if (uniques[i] == 1)
                return;
        }
        if (arr[i] == 0) {
            res = true;
        } else {
            uniques[i] = 1;
            int l = i - arr[i];
            int r = i + arr[i];
            /* <-.递归dfs左右子树:↓.*/
            dfs(l, uniques, arr); dfs(r, uniques, arr);
        }
    }
}