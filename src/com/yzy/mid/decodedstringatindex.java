package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/30 00:04
 * @Description
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 *
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解释：
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
 * 字符串中的第 10 个字母是 "o"。
 * 示例 2：
 *
 * 输入：S = "ha22", K = 5
 * 输出："h"
 * 解释：
 * 解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
 * 示例 3：
 *
 * 输入：S = "a2345678999999999999999", K = 1
 * 输出："a"
 * 解释：
 * 解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 * @Version 1.0
 */
public class decodedstringatindex {
    public String decodeAtIndex(String s, int k) {
        long cnt = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            cnt = Character.isDigit(s.charAt(i)) ? cnt*(s.charAt(i)-'0') : cnt+1;
        }
        for (i--; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                cnt /= (s.charAt(i)-'0');
                k %= cnt;
            } else {
                if (k % cnt == 0) return s.charAt(i)+"";
                cnt--;
            }
        }
        return "";
    }
}