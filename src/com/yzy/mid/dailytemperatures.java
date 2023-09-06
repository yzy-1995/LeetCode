package com.yzy.mid;

import java.util.Stack;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/04 00:48
 * @Description
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * @Version 1.0
 */
public class dailytemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            /**
             * 取出下标进行元素值的比较
             */
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            /**
             * 注意 放入的是元素位置
             */
            stack.push(i);
        }
        return res;
    }
}