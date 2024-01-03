package com.yzy.mid;

import java.util.ArrayList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/03 09:40
 * @Description
 * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 *
 * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 *
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "10101"
 * 输出：4
 * 解释：总共有 4 种方法将 s 分割成含有 '1' 数目相同的三个子字符串。
 * "1|010|1"
 * "1|01|01"
 * "10|10|1"
 * "10|1|01"
 * 示例 2：
 *
 * 输入：s = "1001"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "0000"
 * 输出：3
 * 解释：总共有 3 种分割 s 的方法。
 * "0|0|00"
 * "0|00|0"
 * "00|0|0"
 * 示例 4：
 *
 * 输入：s = "100100010100110"
 * 输出：12
 * @Version 1.0
 */
public class numberofwaystosplitastring {
    public int numWays(String s) {
        int n = s.length(),mod = 1000000007;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                list.add(i);//每个‘1’的位置
            }
        }
        int count = list.size();
        long res = 0;
        if(count%3!=0)return (int)res;
        else if(count==0){
            res = (n-1)%mod;
            res *= (n-2)%mod;
            res/=2;
            res %= mod;
        }
        else{
            // 三个字符串间 有两个可分配0区间 长度相乘即为结果
            long len1 =list.get(count/3)-list.get(count/3-1);
            long len2 = list.get(count/3*2)-list.get(count/3*2-1);
            res = (len1*len2)%mod;
        }
        return (int)res;
    }
}