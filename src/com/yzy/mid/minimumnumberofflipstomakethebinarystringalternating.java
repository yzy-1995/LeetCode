package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/17 00:33
 * @Description
 * 给你一个二进制字符串 s 。你可以按任意顺序执行以下两种操作任意次：
 *
 * 类型 1 ：删除 字符串 s 的第一个字符并将它 添加 到字符串结尾。
 * 类型 2 ：选择 字符串 s 中任意一个字符并将该字符 反转 ，也就是如果值为 '0' ，则反转得到 '1' ，反之亦然。
 * 请你返回使 s 变成 交替 字符串的前提下， 类型 2 的 最少 操作次数 。
 *
 * 我们称一个字符串是 交替 的，需要满足任意相邻字符都不同。
 *
 * 比方说，字符串 "010" 和 "1010" 都是交替的，但是字符串 "0100" 不是。
 *
 *
 * 示例 1：
 *
 * 输入：s = "111000"
 * 输出：2
 * 解释：执行第一种操作两次，得到 s = "100011" 。
 * 然后对第三个和第六个字符执行第二种操作，得到 s = "101010" 。
 * 示例 2：
 *
 * 输入：s = "010"
 * 输出：0
 * 解释：字符串已经是交替的。
 * 示例 3：
 *
 * 输入：s = "1110"
 * 输出：1
 * 解释：对第二个字符执行第二种操作，得到 s = "1010" 。
 * @Version 1.0
 */
public class minimumnumberofflipstomakethebinarystringalternating {
    public int minFlips(String s) {
        int c1=0,c2=0;//分别记载偶数、奇数位的1的个数
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(i%2==0){c1++;}
                else{c2++;}
            }
        }
        //先判断s长度偶数的情况，而后奇数
        if(s.length()%2==0){return s.length()/2-Math.abs(c1-c2);}
        int ans=Math.min(c1-c2,c2-c1+1);
        for(int i=0;i<s.length()-1;i++){
            int c=c2;c2=c1;c1=c;
            if(s.charAt(i)=='1'){c1++;c2--;}
            ans=Math.min(ans,Math.min(c1-c2,c2-c1+1));
        }
        return ans+s.length()/2;
    }
}