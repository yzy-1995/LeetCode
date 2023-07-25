package com.yzy.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/24 00:11
 * @Description
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 *
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 *
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * 示例 2:
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 示例 3:
 *
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 * @Version 1.0
 */
public class CaniWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 尝试暴力的记忆化深搜(看题解)
        if ((maxChoosableInteger * (1 + maxChoosableInteger) >> 1) < desiredTotal) {
            return false;
        }
        // 判断当前层, 也就是当前先手玩家能否获胜, dfs过程中, 两个玩家都全力保证自己每一层的选择能获胜
        return dfs(maxChoosableInteger, desiredTotal, 0, 0, new HashMap<>(16));
    }

    /**
     * 记忆化深搜
     * @param maxChoosableInteger  最大可选值1-maxChoosableInteger
     * @param desiredTotal         最大值
     * @param usedState            当前使用数字的状态, 因为数字1-20
     * @param curTotal             当前total
     * @param memory               记忆化数组
     * @return                     返回是否胜利
     */
    private boolean dfs(int maxChoosableInteger, int desiredTotal, int usedState, int curTotal, Map<Integer, Boolean> memory) {
        // 每一层的玩家不同, 但是目的都是当前层能获胜 || 下一层不能获胜则当前层能获胜
        Boolean result = memory.get(usedState);
        if (result != null) {
            return result;
        }
        result = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            // 暴力
            if (((usedState >> i) & 1) == 0) {
                if (i + 1 + curTotal >= desiredTotal) {
                    // 如果当前的玩家能获胜
                    result = true;
                    break;
                } else if (!dfs(maxChoosableInteger, desiredTotal, usedState | (1 << i), i + 1 + curTotal, memory)) {
                    // 如果它下一个玩家不能获胜, 那么当前玩家能获胜
                    result = true;
                    break;
                }
            }
        }
        memory.put(usedState, result);
        return result;
    }
}