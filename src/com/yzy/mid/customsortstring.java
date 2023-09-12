package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/12 00:07
 * @Description
 * 给定两个字符串 order 和 s 。order 的所有字母都是 唯一 的，并且以前按照一些自定义的顺序排序。
 *
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 *
 * 返回 满足这个性质的 s 的任意一种排列 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * 示例 2:
 *
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * @Version 1.0
 */
public class customsortstring { public String customSortString(String order, String s) {
    // 排序, 只不过compare的时候, 按照order的大小来比较
    // 1.尝试花费空间够建一个哈希表, 使得比较的时候能够O(1)
    int orderLength = order.length();
    int[] orderIndexTable = new int[26];
    // 提交后发现这里可以不需要fill
    Arrays.fill(orderIndexTable, -1);
    for (int i = 0; i < orderLength; i++) {
        orderIndexTable[order.charAt(i) - 'a'] = i;
    }
    // 2.对s进行排序
    char[] sChars = s.toCharArray();
    quickSort(sChars, 0, sChars.length - 1, orderIndexTable);
    return new String(sChars);
}

    private void quickSort(char[] chars, int left, int right, int[] orderIndexTable) {
        if (left < right) {
            int lt = left - 1;
            int rt = right + 1;
            int curIndex = left;
            char curValue = chars[curIndex];
            char temp;
            while (curIndex < rt) {
                if (compare(curValue, chars[curIndex], orderIndexTable) == 1) {
                    temp = chars[++lt];
                    chars[lt] = chars[curIndex];
                    chars[curIndex++] = temp;
                } else if (compare(curValue, chars[curIndex], orderIndexTable) == -1) {
                    temp = chars[--rt];
                    chars[rt] = chars[curIndex];
                    chars[curIndex] = temp;
                } else {
                    curIndex++;
                }
            }
            quickSort(chars, left, lt, orderIndexTable);
            quickSort(chars, rt, right, orderIndexTable);
        }
    }

    /**
     * compare
     *
     * @param a               a
     * @param b               b
     * @param orderIndexTable orderIndexTable
     * @return a>b return 1; a<b return -1; a==b return 0;
     */
    private int compare(char a, char b, int[] orderIndexTable) {
        return Integer.compare(orderIndexTable[a - 'a'], orderIndexTable[b - 'a']);
    }
}