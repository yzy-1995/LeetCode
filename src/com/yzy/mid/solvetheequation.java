package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/18 00:03
 * @Description
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * @Version 1.0
 */
public class solvetheequation {
    public String solveEquation(String equation) {
        int index = -1;
        equation = equation.replace("-", "+-");
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                index = i;
                break;
            }
        }
        //等号左边
        String leftEqual = equation.substring(0, index);
        //等号右边
        String rightEqual = equation.substring(index + 1);
        String[] left = leftEqual.split("\\+");
        String[] right = rightEqual.split("\\+");
        int[] leftNum = getNum(left);
        int[] rightNum = getNum(right);
        int x = leftNum[0] - rightNum[0];
        int num = leftNum[1] - rightNum[1];
        if (x == 0) {
            if (num == 0) return "Infinite solutions";
            else return "No solution";
        } else return "x=" + (-num / x);
    }

    private int[] getNum(String[] strs) {
        int xTotal = 0;
        int numTotal = 0;
        for (String str : strs) {
            if (str.equals("")) continue;
            else if (str.contains("x")) {
                if (str.length() == 1) {
                    xTotal++;
                } else if (str.length() == 2 && str.charAt(0) == '-') {
                    xTotal--;
                } else {
                    String left = str.substring(0, str.length() - 1);
                    xTotal += Integer.valueOf(left);
                }
            } else numTotal += Integer.valueOf(str);
        }
        return new int[]{xTotal, numTotal};
    }
}