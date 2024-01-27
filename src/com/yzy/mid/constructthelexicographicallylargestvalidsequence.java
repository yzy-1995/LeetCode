package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/23 00:06
 * @Description
 * 给你一个整数 n ，请你找到满足下面条件的一个序列：
 *
 * 整数 1 在序列中只出现一次。
 * 2 到 n 之间每个整数都恰好出现两次。
 * 对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。
 * 序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。
 *
 * 请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。
 *
 * 一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[3,1,2,3,2]
 * 解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[5,3,1,4,3,5,2,4,2]
 * @Version 1.0
 */
public class constructthelexicographicallylargestvalidsequence {
    public int[] constructDistancedSequence(int n) {
        int[] rs = new int[n*2-1];
        dfs(rs,new boolean[n],0);
        return rs;
    }
    public boolean dfs(int[] rs,boolean[] bs,int i){
        if(i==rs.length)return true;
        if(rs[i]!=0)return dfs(rs,bs,i+1);
        for(int j=bs.length;j>=1;j--){
            if(!bs[j-1]){
                if(j==1){
                    rs[i]=j;
                    bs[j-1]=true;
                    if(dfs(rs,bs,i+1))return true;
                    bs[j-1]=false;
                    rs[i]=0;
                }else{
                    if(i+j>=rs.length)return false;
                    if(rs[i+j]!=0)continue;
                    rs[i]=j;
                    rs[i+j]=j;
                    bs[j-1]=true;
                    if(dfs(rs,bs,i+1))return true;
                    bs[j-1]=false;
                    rs[i]=0;
                    rs[i+j]=0;
                }
            }
        }
        return false;
    }
}