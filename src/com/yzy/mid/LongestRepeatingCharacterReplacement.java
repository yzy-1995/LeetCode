package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/17 01:13
 * @Description 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * <p>
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果。
 * @Version 1.0
 */
public class LongestRepeatingCharacterReplacement {
    char arr1[];
    int k;

    public int characterReplacement(String s, int k) {
        this.arr1 = s.toCharArray();
        this.k = k;
        int n = s.length();
        int i = k, j = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (check(mid)) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }

    boolean check(int mid) {
        int l = 0;
        int arr[] = new int[26];
        while (l < arr1.length) {
            arr[arr1[l] - 'A']++;
            if (l >= mid) {
                arr[arr1[l - mid] - 'A']--;
            }
            int max = 0;
            for (int i = 0; i < 26; ++i) {
                max = Math.max(arr[i], max);
            }
            if (mid - max <= k) return true;
            ++l;
        }
        return false;

    }
}