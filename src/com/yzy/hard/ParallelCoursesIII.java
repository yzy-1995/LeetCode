package com.yzy.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/07/28 00:05
 * @Description
 * 给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。同时给你一个二维整数数组 relations ，其中 relations[j] = [prevCoursej, nextCoursej] ，表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。同时给你一个下标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。
 *
 * 请你根据以下规则算出完成所有课程所需要的 最少 月份数：
 *
 * 如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。
 * 你可以 同时 上 任意门课程 。
 * 请你返回完成所有课程所需要的 最少 月份数。
 *
 * 注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入：n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
 * 输出：8
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 和 2 。
 * 课程 1 花费 3 个月，课程 2 花费 2 个月。
 * 所以，最早开始课程 3 的时间是月份 3 ，完成所有课程所需时间为 3 + 5 = 8 个月。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
 * 输出：12
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 ，2 和 3 。
 * 在月份 1，2 和 3 分别完成这三门课程。
 * 课程 4 需在课程 3 之后开始，也就是 3 个月后。课程 4 在 3 + 4 = 7 月完成。
 * 课程 5 需在课程 1，2，3 和 4 之后开始，也就是在 max(1,2,3,7) = 7 月开始。
 * 所以完成所有课程所需的最少时间为 7 + 5 = 12 个月。
 * @Version 1.0
 */
public class ParallelCoursesIII {
    public void learn(int []time , int []finalTime, List<Integer>[]list, int index){
        // 已计算过时间
        if(finalTime[index]>0) return;
        finalTime[index] = time[index-1];
        // 遍历所有前提课程，计算可以学习本课程的时间
        for(int pre:list[index]){
            learn(time,finalTime,list,pre);
            finalTime[index] = Math.max(finalTime[index],finalTime[pre]+time[index-1]);
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        // 构建邻接表
        List<Integer> []list = new List[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int []r:relations){
            list[r[1]].add(r[0]);
        }
        // 存储可以学习完第i节课的时间，-1表示未计算
        int []finalTime = new int[n+1];
        Arrays.fill(finalTime,-1);
        int max = 0;
        for(int i=1;i<=n;i++){
            learn(time,finalTime,list,i);
            max = Math.max(max,finalTime[i]);
        }
        return max;
    }
}