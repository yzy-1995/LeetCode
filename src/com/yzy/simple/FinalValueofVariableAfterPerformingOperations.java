package com.yzy.simple;

/**
 * ClassName: FinalValueofVariableAfterPerformingOperations
 * Description:
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
 * ++X 和 X++ 使变量 X 的值 加 1
 * --X 和 X-- 使变量 X 的值 减 1
 * 最初，X 的值是 0
 * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
 * 示例 1：
 * 输入：operations = ["--X","X++","X++"]
 * 输出：1
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * --X：X 减 1 ，X =  0 - 1 = -1
 * X++：X 加 1 ，X = -1 + 1 =  0
 * X++：X 加 1 ，X =  0 + 1 =  1
 * 示例 2：
 * 输入：operations = ["++X","++X","X++"]
 * 输出：3
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * ++X：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * X++：X 加 1 ，X = 2 + 1 = 3
 * 示例 3：
 * 输入：operations = ["X++","++X","--X","X--"]
 * 输出：0
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * X++：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * --X：X 减 1 ，X = 2 - 1 = 1
 * X--：X 减 1 ，X = 1 - 1 = 0
 *
 * @author Administrator
 * @date 2023-5-4 14:52
 */
public class FinalValueofVariableAfterPerformingOperations {
    public static void main(String[] args) {

    }

    public int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String operation : operations) {
            if (operation.equals("++X")) {
                count++;
            } else if (operation.equals("--X")) {
                count--;
            } else if (operation.equals("X++")) {
                count++;
            } else if (operation.equals("X--")) {
                count--;
            }
        }
        return count;
    }
}
