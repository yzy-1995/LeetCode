package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/18 00:06
 * @Description
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 *
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 *
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 *
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * @Version 1.0
 */
public class maximumnumberofvowelsinasubstringofgivenlength {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while(right<s.length()){
            char temp = s.charAt(right);
            if(temp=='a'||temp=='e'||temp=='i'||temp=='o'||temp=='u'){
                count++;
            }
            right++;
            if (right-left==k){
                max = Math.max(max,count);
                char c = s.charAt(left);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    count--;
                }
                left++;
            }
        }
        return max;
    }
}