package com.yzy.mid;

import java.util.*;

/**
 * ClassName: GroupAnagrams
 * Description:
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author Administrator
 * @date 2023-5-22 15:46
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        for (List<String> list : groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            for (String s : list) {
                System.out.println(s);
            }

        }

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
