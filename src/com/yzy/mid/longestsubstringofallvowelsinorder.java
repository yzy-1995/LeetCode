package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/02/09 17:30
 * @Description
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 *
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 *
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 *
 * 子字符串 是字符串中一个连续的字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * 示例 2：
 *
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * 示例 3：
 *
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * @Version 1.0
 */
public class longestsubstringofallvowelsinorder {
    public int longestBeautifulSubstring(String word) {
        int type=1,max=0;
        for (int i=0,j = 1; j < word.length(); j++) {
            //如果匹配到未按照升序排列 窗口收缩 重新开始滑动
            if(word.charAt(j)<word.charAt(j-1)){
                i=j;
                type=1;
            }else if(word.charAt(j)>word.charAt(j-1)){//如果匹配到按照升序排列 类型增加1
                type++;
            }
            //如果类型为5 代表当前窗口aeiou元音组成是有效的
            if(type==5){
                max=Math.max(max, j-i+1);
            }
        }
        return max;
    }
}