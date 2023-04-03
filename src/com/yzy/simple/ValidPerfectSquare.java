package com.yzy.simple;

/**
 * ClassName: ValidPerfectSquare
 * Description:
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 *
 * @author Administrator
 * @date 2023-4-3 17:17
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(16));
    }

    public boolean isPerfectSquare(int num) {
        if (num<2){
            return true;
        }
        Math.sqrt(num);
        long left = 0;
        long right = num/2;
        while (left <= right){
            long mid = (left + right)/2;
            long squareMid = mid * mid;
            if (squareMid==num){
                return  true;
            }else if (squareMid>num){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
