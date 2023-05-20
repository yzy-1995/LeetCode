package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: l
 * 珠玑妙算游戏（the game of master mind）的玩法如下。
 * <p>
 * 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * <p>
 * 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。
 * <p>
 * 示例：
 * <p>
 * 输入： solution="RGBY",guess="GGRR"
 * 输出： [1,1]
 * 解释： 猜中1次，伪猜中1次。
 *
 * @author yzy15
 * @date 2023/05/20 16:19
 **/
public class MasterMind {

    public int[] masterMind(String solution, String guess) {
        int l = solution.length();
        int[] ans = new int[2];
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < l; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ans[0]++;
            } else {
                map1.put(solution.charAt(i), map1.getOrDefault(solution.charAt(i), 0) + 1);
                map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        // R-BY  R1 B1 Y1
        // G-RR  G1 R2
        for (char c : map2.keySet()) {
            if (map1.containsKey(c)) {
                ans[1] += map2.get(c) > map1.get(c) ? map1.get(c) : map2.get(c);
            }
        }
        return ans;
    }
}
