package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/12 22:33
 * @Description
 * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
 *
 * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
 *
 * 任意两个字符都可以进行交换，不必相邻 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "111000"
 * 输出：1
 * 解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
 * 示例 2：
 *
 * 输入：s = "010"
 * 输出：0
 * 解释：字符串已经是交替字符串了，不需要交换。
 * 示例 3：
 *
 * 输入：s = "1110"
 * 输出：-1
 * @Version 1.0
 */
public class minimumnumberofswapstomakethebinarystringalternating {
    public int minSwaps(String s) {
        int n = s.length();
        int count = 0;
        int oneCount = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                count++;
                if(i % 2 == 0){
                    oneCount++;
                }
            }
        }
        if(n % 2 == 0){
            if(count != n / 2){
                return -1;
            }
            return Math.min(n / 2 - oneCount, oneCount);
        }
        if(count < n / 2 || count > n / 2 + 1){
            return -1;
        }
        if(count == n / 2){
            return oneCount;
        }else{
            return n / 2 + 1 - oneCount;
        }
    }
}