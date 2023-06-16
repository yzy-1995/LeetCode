package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/17 02:40
 * @Description 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * @Version 1.0
 */
public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = backTrace(expression, 0, expression.length());
        return res;
    }

    private List<Integer> backTrace(String expression, int start, int end) {
        List<Integer> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                List<Integer> left = diffWaysToCompute(expression.substring(start, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, end));
                for (int lefttemp : left) {
                    for (int righttemp : right) {
                        if (c == '+') res.add(lefttemp + righttemp);
                        else if (c == '-') res.add(lefttemp - righttemp);
                        else if (c == '/') res.add(lefttemp / righttemp);
                        else res.add(lefttemp * righttemp);
                    }

                }

            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}