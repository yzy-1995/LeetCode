package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode914
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 示例 1：
 * 输入：deck = [1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * 输入：deck = [1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * @author yzy15
 * @date 2023/04/22 12:47
 **/
public class XofaKindinaDeckofCards {
    public static void main(String[] args) {

    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        int gcd = -1;
        for (int count : countMap.values()) {
            if (gcd == -1) {
                gcd = count;
            } else {
                gcd = gcd(gcd, count);
            }
        }

        return gcd >= 2;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }
}
