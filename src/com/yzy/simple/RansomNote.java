package com.yzy.simple;

import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: RansomNote
 * Description:
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * @author Administrator
 * @date 2023-4-4 14:07
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("aaaaaaaaaaaaaaaab", "aaaaaaaaaaaaaaaaaaaaaaaab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()){
            return false;
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineMap.put(c, magazineMap.getOrDefault(c,0)+1);
        }
        for (char c :ransomNote.toCharArray()) {
            if (magazineMap.containsKey(c) || magazineMap.get(c)<=0){
                return false;
            }
        }
        return true;
    }
}
