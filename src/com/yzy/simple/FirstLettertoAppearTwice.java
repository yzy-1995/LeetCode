package com.yzy.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: FirstLettertoAppearTwice
 * Description:
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * 注意：
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 * 示例 1：
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * 示例 2：
 * 输入：s = "abcdd"
 * 输出："d"
 * 解释：
 * 只有字母 'd' 出现两次，所以返回 'd' 。
 * @author Administrator
 * @date 2023-5-10 14:27
 */
public class FirstLettertoAppearTwice {
    public static void main(String[] args) {

    }

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<Character>();
        for (char c :s.toCharArray()) {
            if (set.contains(c)){
                return c;
            }else {
                set.add(c);
            }
        }
        return 0;
    }
}
