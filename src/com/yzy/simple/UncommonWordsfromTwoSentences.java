package com.yzy.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: leetcode884
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * 示例 1：
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * @author yzy15
 * @date 2023/04/22 02:24
 **/
public class UncommonWordsfromTwoSentences {
    public static void main(String[] args) {
        System.out.println(new UncommonWordsfromTwoSentences().uncommonFromSentences("this apple is sweet", "this apple is sour"));
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map =new HashMap<>();
        List<String> list =new ArrayList<>();
        for (String  str :s1.split(" ")) {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for (String  str :s2.split(" ")) {
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value==1){
                list.add(key);
            }
        }

        return list.toArray(new String[0]);
    }
}
