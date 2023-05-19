package com.yzy.simple;

/**
 * ClassName: OfferII072
 * Description:
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 *
 *
 * 示例 1:
 *
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 * @author Administrator
 * @date 2023-5-19 16:00
 */
public class OfferII072 {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(mid <= x / mid && (mid + 1)> x  / (mid + 1) ){
                return (int)mid;
            }else if(mid > x /mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
