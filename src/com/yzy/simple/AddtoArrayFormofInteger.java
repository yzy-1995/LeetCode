package com.yzy.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description: leetcode989
 * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * 示例 1：
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * @author yzy15
 * @date 2023/04/23 22:27
 **/
public class AddtoArrayFormofInteger {
    public static void main(String[] args) {

    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = k;
        int idx = num.length - 1;

        while (idx >= 0 || carry > 0) {
            if (idx >= 0) {
                carry += num[idx];
            }
            result.add(carry % 10);
            carry /= 10;
            idx--;
        }

        Collections.reverse(result);
        return result;
    }
}
