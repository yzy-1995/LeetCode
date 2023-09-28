package com.yzy.mid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/28 00:05
 * @Description
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：false
 * @Version 1.0
 */
public class reorderedpowerof2 {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i > 0; i <<= 1) {
            set.add(numToStr(i));
        }
        return set.contains(numToStr(n));
    }

    private String numToStr(int i) {
        char[] c = String.valueOf(i).toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}