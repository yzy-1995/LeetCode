package com.yzy.mid;

import lombok.val;

/**
 * ClassName: ReverseWordsInaString
 * Description:
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 * @author Administrator
 * @date 2023-6-5 11:09
 */
public class ReverseWordsInaString {
    public String reverseWords(String s) {
        s = ' ' + s;
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int left = n - 1, right = n; left >= 0; left--) {
            char ch = s.charAt(left);
            if (ch == ' ') {
                if (left + 1 < right) {
                    ans.append(s, left + 1, right);
                    ans.append(' ');
                }
                right = left;
            }
        }
        return ans.substring(0, ans.length() - 1);
    }
}
