package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Offer57II
 * Description:
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author Administrator
 * @date 2023-5-18 10:39
 */
public class Offer57II {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        int left = 1;
        int right = 2;

        //终止条件是左指针移动到右指针位置，说明此时已经不存在两个数之和能小于 target 了
        while (left < right) {

            int sum = (right - left + 1) * (left + right) / 2;

            if (sum == target) {
                //创建数组存储左右指针之间的数组组合
                int[] tmp = new int[right - left + 1];

                for (int i = 0; i < right - left + 1; i++) {
                    tmp[i] = left + i;
                }

                //将临时数组结果存储入List
                list.add(tmp);

                //继续探索下一种方案
                ++left;
            } else if (sum < target) {
                ++right;
            } else {
                ++left;
            }

        }

        //掌握此种二维list转数组方法
        return list.toArray(new int[list.size()][]);
    }
}
