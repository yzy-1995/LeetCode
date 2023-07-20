package com.yzy.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/07/21 00:19
 * @Description
 * 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 *
 * 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
 *
 * 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
 * 输出：4
 * 解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 10 + -10 + |5 - 6| = 1 。
 * 没有其他满足条件的点，所以返回 4 和 1 中最大的那个。
 * 示例 2：
 *
 * 输入：points = [[0,0],[3,0],[9,2]], k = 3
 * 输出：3
 * 解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
 * @Version 1.0
 */
public class MaxVvalueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> q=new ArrayDeque<>();
        int n=points.length,ans=-(int)3e8;
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&points[i][0]>q.getFirst()[0]+k){q.removeFirst();}
            if(!q.isEmpty()){ans=Math.max(ans,points[i][1]+points[i][0]-q.getFirst()[0]+q.getFirst()[1]);}
            while(!q.isEmpty()&&points[i][1]-points[i][0]>=q.getLast()[1]-q.getLast()[0]){q.removeLast();}
            q.add(points[i]);
        }
        return ans;
    }
}