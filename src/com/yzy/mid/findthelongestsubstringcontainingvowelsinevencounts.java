package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/03 16:38
 * @Description
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 * 示例 2：
 *
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 * 示例 3：
 *
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 * @Version 1.0
 */
public class findthelongestsubstringcontainingvowelsinevencounts {
    public int findTheLongestSubstring(String s) {
        //一共32个状态，用数组记录比哈希表快，故用数组记录即可
        //时间复杂度：o(n) 空间复杂度： o(1)
        int[] map = new int[32];
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        Arrays.fill(map,-2);
        map[0] = -1;
        int ans = 0;
        for(int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            if(c == 'a') a = (a + 1) % 2;
            if(c == 'e') e = (e + 1) % 2;
            if(c == 'i') i = (i + 1) % 2;
            if(c == 'o') o = (o + 1) % 2;
            if(c == 'u') u = (u + 1) % 2;
            int n = a * 1 + e * 2 + i * 4 + o * 8 + u * 16;
            if(map[n] != -2) ans = Math.max(ans, j - map[n]);
            else map[n] = j;
        }
        return ans;
    }
}