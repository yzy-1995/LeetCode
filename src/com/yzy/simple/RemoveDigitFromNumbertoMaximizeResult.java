package com.yzy.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: RemoveDigitFromNumbertoMaximizeResult
 * Description:
 * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
 * 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。
 * 生成的测试用例满足 digit 在 number 中出现至少一次。
 * 示例 1：
 * 输入：number = "123", digit = "3"
 * 输出："12"
 * 解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
 * 示例 2：
 * 输入：number = "1231", digit = "1"
 * 输出："231"
 * 解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
 * 由于 231 > 123 ，返回 "231" 。
 * 示例 3：
 * 输入：number = "551", digit = "5"
 * 输出："51"
 * 解释：可以从 "551" 中移除第一个或者第二个 '5' 。
 * 两种方案的结果都是 "51" 。
 * @author Administrator
 * @date 2023-5-8 11:40
 */
public class RemoveDigitFromNumbertoMaximizeResult {
    public static void main(String[] args) {

    }


    public String removeDigit(String number, char digit) {
        int n = number.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                list.add(number.substring(0, i) + number.substring(i + 1, n));
            }
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
