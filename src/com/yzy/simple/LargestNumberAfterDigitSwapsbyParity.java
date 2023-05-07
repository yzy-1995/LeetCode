package com.yzy.simple;

import java.util.ArrayList;

/**
 * Description: leetcode2231
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * 返回交换 任意 次之后 num 的 最大 可能值。
 * 示例 1：
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 * @author yzy15
 * @date 2023/05/07 09:25
 **/
public class LargestNumberAfterDigitSwapsbyParity {
    public static void main(String[] args) {

    }

    public int largestInteger(int num) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        int[] a = new int[String.valueOf(num).length()];
        int m = 0, n = 0,len = a.length - 1;
        while (num != 0) {
            int r = num % 10;
            if (r % 2 == 0) {
                even.add(r);
                a[len--] = 0;
            } else {
                odd.add(r);
                a[len--] = 1;
            }
            num /= 10;
        }
        odd.sort((o1, o2) -> o2 - o1);
        even.sort((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                a[i] = odd.get(m++);
            } else {
                a[i] = even.get(n++);
            }
            sb.append(a[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
