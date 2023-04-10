package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FirstUniqueCharacterinaString
 * Description:
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * @author Administrator
 * @date 2023-4-10 15:23
 */
public class FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        FirstUniqueCharacterinaString firstUniqueCharacterinaString = new FirstUniqueCharacterinaString();
        System.out.println(firstUniqueCharacterinaString.firstUniqChar("aabb"));
    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map  = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i))==1){
                    return i;
                }
            }
        }
        return -1;
    }
}
