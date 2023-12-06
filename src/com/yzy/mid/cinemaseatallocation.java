package com.yzy.mid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/06 08:14
 * @Description
 * 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 *
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 *
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * 输出：4
 * 解释：上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
 * 示例 2：
 *
 * 输入：n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * 输出：4
 * @Version 1.0
 */
public class cinemaseatallocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Set<Integer> set = map.getOrDefault(reservedSeat[0], new HashSet<>());
            set.add(reservedSeat[1]);
            map.put(reservedSeat[0], set);
        }

        int ans = 2 * n;
        for (Integer row : map.keySet()) {
            Set<Integer> set = map.get(row);
            int cnt = 0;
            //考虑2,5之间知否有
            if (isOk(2, 5, set)) {
                cnt++;
            }

            //考虑6，9之间是否有
            if (isOk(6, 9, set)) {
                cnt++;
                //这里还有一种特殊情况：就是2,5有，但是都在最左边；6,9有，但是都在最右边，而此时4,7就符合条件，不需要减去
                if (isOk(2, 5, set) && !isOk(4, 7, set)) cnt--;
            }
            ans -= cnt;
        }
        return ans;
    }


    private boolean isOk(int i, int i1, Set<Integer> set) {
        for (int j = i; j <= i1; j++) {
            if (set.contains(j)) return true;
        }
        return false;
    }
}