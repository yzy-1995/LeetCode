package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: LetterCombinationsOfAPhoneNumber
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Administrator
 * @date 2023-3-28 14:55
 */
public class LetterCombinationsOfAPhoneNumber {

    private Map<Character, String> mapping = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 我们可以使用回溯算法来解决这个问题。具体来说，我们维护一个字符串 combination 表示当前已经生成的字母组合，
     * 一个整数 index 表示当前处理到了 digits 中的第几个数字，以及一个字典 mapping 表示数字和字母之间的映射关系。
     * 在回溯的过程中，对于 digits 中的每个数字，我们枚举数字对应的每个字母，将字母添加到 combination 中，并将 index 加 1。
     * 当 index 等于 digits 的长度时，说明已经处理完了所有数字，将 combination 添加到答案中即可。
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int index, StringBuilder combination, List<String> ans) {
        if (index == digits.length()) {
            ans.add(combination.toString());
            return;
        }
        String letters = mapping.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(digits, index + 1, combination, ans);
            combination.deleteCharAt(combination.length() - 1);
        }
    }


}
