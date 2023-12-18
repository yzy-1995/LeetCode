package com.yzy.mid;

import java.math.BigInteger;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/11 00:07
 * @Description
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *
 * 如果当前数字为偶数，则将其除以 2 。
 *
 * 如果当前数字为奇数，则将其加上 1 。
 *
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 *
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 *
 * 输入：s = "1"
 * 输出：0
 * @Version 1.0
 */
public class numberofstepstoreduceanumberinbinaryrepresentationtoone {
    private static final int BASIC_RADIX = 2;

    private static final String NUM2_STR = "2";

    private static final String ONE_STR = "1";

    private static final String ZERO_STR = "0";

    public int numSteps(String s) {
        int len = s.length();
        int count = 0;
        if (len == 1 && s.charAt(0) == '1') {
            return count;
        }
        // 转成大整数运算
        BigInteger base = new BigInteger(s, BASIC_RADIX);
        BigInteger zero = new BigInteger(ZERO_STR);
        BigInteger one = new BigInteger(ONE_STR);
        BigInteger two = new BigInteger(NUM2_STR);
        // 迭代计算直到满足出口条件
        while (base.compareTo(one) != 0) {
            if(base.mod(two).compareTo(zero) == 0) {
                base = base.divide(two);
            } else {
                base = base.add(one);
            }
            count ++;
        }
        return count;
    }
}