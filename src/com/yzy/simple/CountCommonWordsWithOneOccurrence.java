package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CountCommonWordsWithOneOccurrence
 * Description:
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 * 示例 1：
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * 示例 2：
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * 示例 3：
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 *
 * @author Administrator
 * @date 2023-5-5 16:15
 */
public class CountCommonWordsWithOneOccurrence {
    public static void main(String[] args) {

    }


    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> count1 = new HashMap<>();
        Map<String, Integer> count2 = new HashMap<>();

        for (String word : words1) {
            count1.put(word, count1.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            count2.put(word, count2.getOrDefault(word, 0) + 1);
        }

        int result = 0;
        for (Map.Entry<String, Integer> entry : count1.entrySet()) {
            if (entry.getValue() == 1 && count2.containsKey(entry.getKey()) && count2.get(entry.getKey()) == 1) {
                result++;
            }
        }

        return result;
    }
}
