package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: KeyboardRow
 * Description:
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 * @author Administrator
 * @date 2023-4-12 14:21
 */
public class KeyboardRow {
    public static void main(String[] args) {

    }

    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lowerWord = word.toLowerCase();
            int rowIndex = -1;
            for (int i = 0; i < rows.length; i++) {
                if (rows[i].indexOf(lowerWord.charAt(0)) != -1) {
                    rowIndex = i;
                    break;
                }
            }

            boolean allInSameRow = true;
            for (int i = 1; i < lowerWord.length(); i++) {
                if (rows[rowIndex].indexOf(lowerWord.charAt(i)) == -1) {
                    allInSameRow = false;
                    break;
                }
            }
            if (allInSameRow) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
}
