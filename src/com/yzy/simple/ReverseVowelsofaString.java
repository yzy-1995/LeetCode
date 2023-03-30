package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ReverseVowelsofaString
 * Description:
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * <p>
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 * @author Administrator
 * @date 2023-3-30 16:48
 */
public class ReverseVowelsofaString {
    public static void main(String[] args) {
        ReverseVowelsofaString reverseVowelsofaString = new ReverseVowelsofaString();
        System.out.println(reverseVowelsofaString.reverseVowels("race car"));
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');

        char[] charArray = s.toCharArray();
        while (left < right) {
            if (list.contains(charArray[left]) && list.contains(charArray[right])){
                char c;
                c = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = c;
                right--;
                left++;
            }else if (list.contains(charArray[left])){
                right--;
            }else if (list.contains(charArray[right])){
                left++;
            }else{
                right--;
                left++;
            }

        }
        return new String(charArray);
    }
}
