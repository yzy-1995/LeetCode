package com.yzy.mid;

/**
 * ClassName: CountSortedVowelStrings
 * Description:
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *
 * @author Administrator
 * @date 2023-3-29 9:12
 */
public class CountSortedVowelStrings {
    private int count = 0;
    private char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    /**
     * 1定义一个字符串变量 s 来存储当前生成的字符串。
     * 2定义一个计数器 count 来记录符合条件的字符串数量。
     * 3定义一个元音字母数组 vowels，用来存储元音字母 a, e, i, o, u。
     * 4实现一个回溯函数 backtrack(int index)，其中 index 表示当前生成的字符串长度。
     * 在回溯函数中，我们首先判断当前字符串是否已经达到了长度 n，如果是，我们就将计数器 count 加 1，
     * 然后返回。否则，我们就枚举元音字母并将其加入到字符串 s 中，然后递归调用 backtrack(index+1)。
     * 递归调用完成后，我们需要将字符串 s 的最后一个字符删掉，以便回溯到上一层。
     * 5在主函数中调用回溯函数 backtrack(0)。最终计数器 count 中存储的就是符合条件的字符串数量。
     *
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        backtrack(0, "", n);
        return count;
    }

    private void backtrack(int index, String s, int n) {
        if (index == n) {
            count++;
            return;
        }
        for (char c : vowels) {
            if (s.isEmpty() || c >= s.charAt(s.length() - 1)) {
                s += c;
                backtrack(index + 1, s, n);
                s = s.substring(0, s.length() - 1);
            }
        }
    }
}
