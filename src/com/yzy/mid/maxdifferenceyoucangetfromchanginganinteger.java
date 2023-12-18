package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/14 00:07
 * @Description
 * 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 *
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 *
 * 请你返回 a 和 b 的 最大差值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 * 示例 2：
 *
 * 输入：num = 9
 * 输出：8
 * 解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 9 和 b = 1 ，最大差值为 8
 * 示例 3：
 *
 * 输入：num = 123456
 * 输出：820000
 * 示例 4：
 *
 * 输入：num = 10000
 * 输出：80000
 * 示例 5：
 *
 * 输入：num = 9288
 * 输出：8700
 * @Version 1.0
 */
public class maxdifferenceyoucangetfromchanginganinteger {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int cnt = 0;
        char c = s.charAt(0);
        // 求最大值时：找到第一个不为'9'的字符，并把和原来字符一样的，全部替换。
        char[] maxChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (cnt == 0 && s.charAt(i) != '9') {
                c = s.charAt(i);
                cnt++;
                maxChars[i] = '9';
            } else if (cnt > 0 && s.charAt(i) == c) {
                maxChars[i] = '9';
            }
        }
        int max = Integer.valueOf(String.valueOf(maxChars));
        /* 求最小值时：分为第一位字符是'1'，第一位字符不是'1'的：
           第一位不是'1'的，直接替换成'1'，其他相同的也同样替换
           第一位是'1'的，查找后面既不是'1'，也不是'0'的字符，用'0'替换，其他相同的同样替换
        */
        char[] minChars = s.toCharArray();
        char c1 = minChars[0];
        int flag = 0;
        if (minChars[0] != '1') {
            minChars[0] = '1';
            for (int i = 1; i < minChars.length; i++) {
                if (minChars[i] == c1) {
                    minChars[i] = '1';
                }
            }
        } else {
            for (int i = 0; i < minChars.length; i++) {
                if (minChars[i] != '1' && minChars[i] != '0' && flag == 0) {
                    c1 = minChars[i];
                    flag++;
                    minChars[i] = '0';
                } else if (minChars[i] == c1 && flag > 0) {
                    minChars[i] = '0';
                }
            }
        }
        int min = Integer.valueOf(String.valueOf(minChars));
        return max - min;
    }
}