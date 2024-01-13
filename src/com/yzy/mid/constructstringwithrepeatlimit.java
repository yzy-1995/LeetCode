package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/13 20:30
 * @Description 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
 * <p>
 * 返回 字典序最大的 repeatLimitedString 。
 * <p>
 * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cczazcc", repeatLimit = 3
 * 输出："zzcccac"
 * 解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
 * 字母 'a' 连续出现至多 1 次。
 * 字母 'c' 连续出现至多 3 次。
 * 字母 'z' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
 * 注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
 * 示例 2：
 * <p>
 * 输入：s = "aababab", repeatLimit = 2
 * 输出："bbabaa"
 * 解释：
 * 使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
 * 字母 'a' 连续出现至多 2 次。
 * 字母 'b' 连续出现至多 2 次。
 * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
 * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
 * 注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
 * @Version 1.0
 */
public class constructstringwithrepeatlimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        // 哈希表 + 贪心模拟构造
        // 先哈希表h统计s所有字母出现次数，再从最大字母开始取出并模拟构造，
        // 每次选择当前剩余字母中字典序最大的i,取出至多Min(rep,h[i])个，
        // 若取完后i字母仍有剩余(已连续rep个i字母，故需要插入一个其他字母)，则取一个当前字典序第二大的j插入，
        // 当取完本轮后，1、没有次小字典序字母(j < 0)，或2、已取完最小字典序字母(i == 0)，结束返回ans即可。
        int[] h = new int[26];
        for(char chr : s.toCharArray()) ++h[chr - 'a'];
        StringBuilder ans = new StringBuilder();
        // 每轮从当前剩余字典序最大的字母i处取，至多min(rep,h[i])个
        for(int i = 25; i >= 0; --i){
            // j指向当前剩余的第二小字典序字母。
            int j = i - 1;
            while(true){
                // 每轮取至多min(rep,h[i])个字母，若全部取完h[i]则继续下一轮，从剩余最大字典序重新开始。
                for(int k = 0; k < repeatLimit && h[i] > 0; ++k){
                    --h[i];
                    ans.append((char)(i + 'a'));
                }
                if(h[i] == 0) break;
                //若取完本轮最大字典序的h[i]仍有剩余，需要插入一个其他字母j再继续取i，为保证字典序最大，j取当前剩余第二大字典序字母。
                while(j >= 0 && h[j] == 0){
                    --j;
                }
                // 若i有剩余且没有第二大字典序字母，则无法继续拼接(继续拼接最大字典序的i会使连续长度超过rep)。
                if(j < 0) break;
                // 插入一个次大字典序的其他字母j，保证连续i长度不超过rep且则拼接字符串字典序最大。
                ans.append((char)(j + 'a'));
                --h[j];
            }
        }
        return ans.toString();
    }

}