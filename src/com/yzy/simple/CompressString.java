package com.yzy.simple;

/**
 * ClassName: CompressString
 * Description:
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * <p>
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * 示例2:
 * <p>
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author Administrator
 * @date 2023-5-19 16:27
 */
public class CompressString {

    public String compressString(String S) {
        if (S.length() == 0) return S;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int slow = 0, fast = 0;
        while (fast <= chars.length) {
            if (fast == chars.length) {
                sb.append(chars[slow]).append(fast - slow);
            } else if (chars[fast] != chars[slow]) {
                sb.append(chars[slow]).append(fast - slow);
                slow = fast;
            }
            fast++;
        }
        return sb.length() < chars.length ? sb.toString() : S;
    }
}
