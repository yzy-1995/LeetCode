package com.yzy.simple;

/**
 * ClassName: CheckifNumbersAreAscendinginaSentence
 * Description:
 * 句子是由若干 token 组成的一个列表，token 间用 单个 空格分隔，句子没有前导或尾随空格。
 * 每个 token 要么是一个由数字 0-9 组成的不含前导零的 正整数 ，要么是一个由小写英文字母组成的 单词 。
 * 示例，"a puppy has 2 eyes 4 legs" 是一个由 7 个 token 组成的句子："2" 和 "4" 是数字，其他像 "puppy" 这样的 tokens 属于单词。
 * 给你一个表示句子的字符串 s ，你需要检查 s 中的 全部 数字是否从左到右严格递增（即，除了最后一个数字，s 中的 每个 数字都严格小于它 右侧 的数字）。
 * 如果满足题目要求，返回 true ，否则，返回 false 。
 * 示例 1：
 * example-1
 * 输入：s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
 * 输出：true
 * 解释：句子中的数字是：1, 3, 4, 6, 12 。
 * 这些数字是按从左到右严格递增的 1 < 3 < 4 < 6 < 12 。
 * 示例 2：
 * 输入：s = "hello world 5 x 5"
 * 输出：false
 * 解释：句子中的数字是：5, 5 。这些数字不是严格递增的。
 * 示例 3：
 * example-3
 * 输入：s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
 * 输出：false
 * 解释：s 中的数字是：7, 51, 50, 60 。这些数字不是严格递增的。
 * 示例 4：
 * 输入：s = "4 5 11 26"
 * 输出：true
 * 解释：s 中的数字是：4, 5, 11, 26 。
 * 这些数字是按从左到右严格递增的：4 < 5 < 11 < 26 。
 * @author Administrator
 * @date 2023-5-5 9:26
 */
public class CheckifNumbersAreAscendinginaSentence {
    public static void main(String[] args) {

    }

    public boolean areNumbersAscending(String s) {
        // 将字符串分割成数组并提取数字
        String[] strArr = s.split(" ");
        int[] numArr = new int[strArr.length];
        int numCount = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].matches("\\d+")) {
                numArr[numCount] = Integer.parseInt(strArr[i]);
                numCount++;
            }
        }

        // 检查数字是否形成递增数列
        boolean isIncreasing = true;
        for (int i = 0; i < numCount-1; i++) {
            if (numArr[i] >= numArr[i+1]) {
                isIncreasing = false;
                break;
            }
        }
        return isIncreasing;
    }
}
