package com.yzy.mid;

import java.awt.*;
import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/19 00:02
 * @Description
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 *
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 示例 2:
 *
 * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * 输出: 0
 * @Version 1.0
 */
public class mostprofitassigningwork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++){
            points[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(points, (a, b) -> ((int)a.getX() - (int)b.getX()));//按照难度升序

        //预处理：由于工作难度和收益不成正比，因此直接二分获取小于等于当前工人能力的最大工作难度不一定有最大收益，因此我们把每个难度的工作的收益设置为小于
        int maxProfit = 0;
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, (int)points[i].getY());
            points[i].setLocation((int)points[i].getX(), maxProfit);
        }

        int res = 0;
        for(int i = 0; i < worker.length; i++){
            int left = -1, right = n;

            while(left + 1 != right){
                // int mid = (left + right) >> 1;
                int mid = left + (right - left) / 2;
                if(points[mid].getX() <= worker[i])left = mid;
                else right = mid;
            }
            System.out.println(left + " ");
            // System.out.print(left == -1 ? 0 : points[left].getY() + " ");
            res += left == -1 ? 0 : (int)points[left].getY();
            System.out.println("res += " + (left == -1 ? 0 : (int)points[left].getY()));


        }
        return res;
}