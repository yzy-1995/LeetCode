package com.yzy.simple;

/**
 * Description: offer05
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @author yzy15
 * @date 2023/05/14 00:14
 **/
public class Offer05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ","%20");
    }
}
