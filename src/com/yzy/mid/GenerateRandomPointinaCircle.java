package com.yzy.mid;

import java.util.Random;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/27 00:16
 * @Description
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 *
 * 实现 Solution 类:
 *
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 *
 *
 * 示例 1：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 * @Version 1.0
 */
public class GenerateRandomPointinaCircle {
    Random random;//随机函数
    double x0, y0, r;//圆心x，y和半径
    public GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        //初始化
        random = new Random();
        x0 = x_center;
        y0 = y_center;
        r = radius;
    }
    // 用正方形包裹圆形，若出现在圆里就输出
    public double[] randPoint() {
        while(true){
            //随机x，y坐标范围
            double x = random.nextDouble() * (2 * r) - r; //定义了x范围为【-r，r】
            double y = random.nextDouble() * (2 * r) - r; //定义y范围【-r，r】
            if(x * x + y * y <= r * r){
                return new double[]{x + x0, y + y0};//加上圆的位置坐标，为圆内随机点
            }
        }

    }
}