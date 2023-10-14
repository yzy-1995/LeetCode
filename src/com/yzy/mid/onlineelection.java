package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/06 03:56
 * @Description
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 *
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 *
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 *
 * 实现 TopVotedCandidate 类：
 *
 * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 *
 * 示例：
 *
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 *
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 *
 * @Version 1.0
 */
public class onlineelection {
    // 人获得的票数
    Map<Integer,Integer> cntMap = new HashMap<>();
    // 当前时间领先的人
    TreeMap<Integer,Integer> tm = new TreeMap<>();
    public onlineelection(int[] persons, int[] times) {
        int maxPersonId = -1;
        for(int i = 0;i < persons.length;i++) {
            // 人的得票增加
            int cnt = cntMap.getOrDefault(persons[i],0) + 1;
            cntMap.put(persons[i],cnt);
            // 之前得票最多的人
            int maxCnt = cntMap.getOrDefault(maxPersonId,0);
            if(cnt >= maxCnt) {
                maxPersonId = persons[i];
            }
            // 维护当前时间得票最多的personId
            tm.put(times[i],maxPersonId);
        }
    }

    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }
}