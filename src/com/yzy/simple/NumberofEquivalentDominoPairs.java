package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NumberofEquivalentDominoPairs
 * Description:
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * @author Administrator
 * @date 2023-4-26 13:59
 */
public class NumberofEquivalentDominoPairs {
    public static void main(String[] args) {

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            String key;
            if (domino[0] < domino[1]) {
                key = domino[0] + "," + domino[1];
            } else {
                key = domino[1] + "," + domino[0];
            }
            int prevCount = map.getOrDefault(key, 0);
            count += prevCount;
            map.put(key, prevCount + 1);
        }

        return count;
    }
}
