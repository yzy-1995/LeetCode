package com.yzy.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: JewelsandStones
 * Description:leetcode771
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * @author Administrator
 * @date 2023-4-20 10:24
 */
public class JewelsandStones {
    public static void main(String[] args) {
        System.out.println(new JewelsandStones().numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> jewelsMap = new HashMap<>();
        int count =0;
        for (Character stone :stones.toCharArray()) {
            jewelsMap.put(stone,jewelsMap.getOrDefault(stone,0)+1);
        }
        for (Character c :jewels.toCharArray()) {
            if (jewelsMap.containsKey(c)){
                count +=jewelsMap.get(c);
            }
        }
        return count;
    }
}
