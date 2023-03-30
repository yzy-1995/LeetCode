package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AddDigits
 * Description:
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 * @author Administrator
 * @date 2023-3-29 15:43
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(708538619));
    }

    int a = 0;

    /**
     * 将数字转成字符串去相加
     * @param num
     * @return
     */
    public int addDigits(int num) {
        String s = String.valueOf(num);
        extracted(s);
        while (a > 10) {
            String b = String.valueOf(a);
            a = 0;
            extracted(b);
        }
        return a;
    }

    private void extracted(String s) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            nums.add(s.charAt(i) - '0');
        }
        for (Integer o : nums) {
            a += o;
        }
    }

    /**
     *
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 我们可以不断地对数字进行求余和除法操作，将每一位数字相加，直到结果为一位数。
     * <p>
     * 时间复杂度：O(logn)，n 表示数字 num 的位数。
     * <p>
     * 空间复杂度：O(1)。
     */
    public int addDigits3(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
