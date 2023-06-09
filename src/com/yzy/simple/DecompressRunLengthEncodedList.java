package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DecompressRunLengthEncodedList
 * Description:
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
 * 每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 *
 * 请你返回解压后的列表。
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 * 示例 2：
 *
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 * @author Administrator
 * @date 2023-4-27 16:59
 */
public class DecompressRunLengthEncodedList {
    public static void main(String[] args) {

    }

    public int[] decompressRLElist(int[] nums) {
        int decompressedLength = 0;
        for (int i = 0; i < nums.length; i += 2) {
            decompressedLength += nums[i];
        }

        int[] decompressedArray = new int[decompressedLength];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                decompressedArray[index++] = val;
            }
        }
        return decompressedArray;
    }
}
