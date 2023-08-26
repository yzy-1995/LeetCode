package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/26 20:30
 * @Description
 * 给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。
 *
 * 有效字符串符合如下规则：
 *
 * 任何左括号 '(' 必须有相应的右括号 ')'。
 * 任何右括号 ')' 必须有相应的左括号 '(' 。
 * 左括号 '(' 必须在对应的右括号之前 ')'。
 * '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "(*)"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(*))"
 * 输出：true
 * @Version 1.0
 */
public class validparenthesisstring {
    public boolean checkValidString(String s) {
        int l = 0;  //l代表左括号比较多，星号作为右括号时左括号的数量
        int h = 0;  //h代表右括号比较多，星号作为左括号时左括号的数量
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') { // ( l和h都增加
                l++;
                h++;
            } else if (tmp == ')') { // ） 如果l不为空，说明左括号比较多，则l--.同时因为h也是代表左括号的数量，所以相应的h--
                if (l > 0) {
                    l--;
                }
                h--;
            } else if (tmp == '*') { // * 如果l不为空，说明左括号比较多，星号作为右括号则l--.同时h是星号作为左括号，所以h++
                if (l > 0) {
                    l--;
                }
                h++;
            }
            if (h < 0) { // h < 0.说明将*当做左括号也不够，返回false
                return false;
            }
        }
        return l == 0; //  同时查看l == 0，如果不等于0，说明将星号视为右括号也不够左括号数量。
    }
}