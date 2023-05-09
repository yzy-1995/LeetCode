package com.yzy.simple;

/**
 * ClassName: StrongPasswordCheckerII
 * Description:
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * 示例 1：
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * 示例 3：
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 *
 * @author Administrator
 * @date 2023-5-9 15:36
 */
public class StrongPasswordCheckerII {
    public static void main(String[] args) {

    }

    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        int[] arr = new int[4];
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[0]++;
            } else if (c >= 'A' && c <= 'Z') {
                arr[1]++;
            } else if (c - '0' >= 0 && c - '0' <= 9) {
                arr[2]++;
            } else if (c == '!' || c == '@' || c == '#' || c == '$' ||
                    c == '%' || c == '^' || c == '&' || c == '*' ||
                    c == '(' || c == ')' || c == '-' || c == '+') {
                arr[3]++;
            }
            if (i > 0 && c == password.charAt(i - 1)) return false;
        }
        // arr里面每一个值都不能为0
        return arr[0] * arr[1] * arr[2] * arr[3] > 0;
    }
}
