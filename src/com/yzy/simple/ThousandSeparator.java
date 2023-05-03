package com.yzy.simple;

/**
 * Description: leetcode1556
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * 示例 1：
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 * 输入：n = 0
 * 输出："0"
 * @author yzy15
 * @date 2023/04/30 16:12
 **/
public class ThousandSeparator {
    public static void main(String[] args) {

    }

    public String thousandSeparator(int n) {
        String numStr = Integer.toString(n);
        StringBuilder res = new StringBuilder();

        int count = 0 ;
        for (int i = numStr.length()-1; i >= 0 ; i--) {
            res.append(numStr.charAt(i));
            count++;
            if (count % 3 == 0 && i!=0){
                res.append(".");
            }
        }
        return res.reverse().toString();
    }
}
