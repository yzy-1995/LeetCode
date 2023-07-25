package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/26 00:19
 * @Description
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * @Version 1.0
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs,int m,int n) {
        if (strs.length == 0) {
            return 0;
        }
        int[][] dp =new int[m+1][n+1];//多维费用问题的0-1背包问题。dp[i][j]表示使用i个0和j个1能表示的字符串的最大数量
        for(String s :strs) {
            //状态转移方程：dp[i][j] = Math.max(dp[i][j],1+dp[i-numZero][j-numOne])
            int zeros  = 0,ones = 0;//统计字符串中一和零的数量。
            for(char c:s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                }else {
                    ones++;
                }
            }
            //这种题做多了之后就知道就是这个套路。
            for (int i = m; i >=zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}