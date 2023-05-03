package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: leetcode1560
 * 给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 * 请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 * 注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 * 示例 1：
 * 输入：n = 4, rounds = [1,3,1,2]
 * 输出：[1,2]
 * 解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
 * 1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
 * 其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。
 * 示例 2：
 * 输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * 输出：[2]
 * 示例 3：
 * 输入：n = 7, rounds = [1,3,5,7]
 * 输出：[1,2,3,4,5,6,7]
 * @author yzy15
 * @date 2023/04/30 16:23
 **/
public class MostVisitedSectorinaCircularTrack {
    public static void main(String[] args) {

    }


    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int [n+1];

        for (int i = 1; i < rounds.length ; i++) {
            int start  = rounds[i-1];
            int end = rounds[i];
            while(start != end){
                count[start]++;
                start = start % n +1;
            }
        }
        count[rounds[rounds.length-1]]++;

        int maxCount = 0;
        for (int i = 1; i <=n ; i++) {
            maxCount = Math.max(maxCount,count[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if (count[i] == maxCount){
                res.add(i);
            }
        }
        return  res;
    }
}
