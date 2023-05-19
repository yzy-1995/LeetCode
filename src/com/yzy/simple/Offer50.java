package com.yzy.simple;

/**
 * ClassName: Offer50
 * Description:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 * @author Administrator
 * @date 2023-5-16 13:40
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        for(int i = 0; i< s.length(); i++){
            char value = s.charAt(i);
            if(s.indexOf(value)==s.lastIndexOf(value)){
                return value;
            }
        }
        return ' ';
    }
}
