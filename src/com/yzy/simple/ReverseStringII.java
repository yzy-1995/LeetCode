package com.yzy.simple;

/**
 * ClassName: ReverseStringII
 * Description:
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 *
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * @author Administrator
 * @date 2023-4-13 10:41
 */
public class ReverseStringII {
    public static void main(String[] args) {

    }

    /**
     * 将字符串转换为字符数组，以便我们可以直接操作数组中的每个字符。
     * 通过遍历字符串中的字符，每次处理 2k 个字符。在每次迭代中，我们需要执行以下操作：
     * a. 计算反转字符的起始索引（left）和结束索引（right）。left 就是当前的迭代索引 i，
     * right 是 Math.min(i + k - 1, n - 1)，其中 n 是字符数组的长度。这样可以确保我们不会超出字符数组的界限。
     * b. 反转 left 和 right 之间的字符。我们可以通过使用两个指针 left 和 right 在数组中交换字符来实现这一点。
     * 这个过程一直持续到 left 和 right 相遇或者越过彼此。
     * 当遍历完成后，将字符数组转换回字符串，并返回结果。
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }

        return new String(chars);
    }
}
