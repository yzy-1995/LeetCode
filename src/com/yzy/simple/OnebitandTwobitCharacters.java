package com.yzy.simple;

/**
 * ClassName: OnebitandTwobitCharacters
 * Description:leetcode717
 * 有两种特殊字符：
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * 示例 1:
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * @author Administrator
 * @date 2023-4-19 10:46
 */
public class OnebitandTwobitCharacters {
    public static void main(String[] args) {

    }

    /**
     * 从左往右扫描bits数组，如果遇到0，则说明当前字符只能是一比特字符，跳过下一个字符；
     * 如果遇到1，则说明当前字符必须是两比特字符，跳过下两个字符。最终判断最后一个字符是否为一比特字符，即可得到结果。
     *
     * 假设bits数组的长度为n，我们可以用一个指针i来表示当前扫描到的位置。如果bits[i]为0
     * ，则说明当前字符只能是一比特字符，将指针i加1。如果bits[i]为1，则说明当前字符必须是两比特字符，
     * 将指针i加2。最终判断i是否等于n-1即可得到结果。
     *
     * 为什么贪心算法是正确的呢？因为一比特字符只有一种可能，而两比特字符有两种可能。
     * 如果当前字符是一比特字符，那么它只能匹配一种情况；如果当前字符是两比特字符，那么它可以匹配两种情况。
     * 因此，我们应该尽量使用两比特字符，这样才能匹配更多的情况，从而使得最后一个字符更有可能是一比特字符。
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}
