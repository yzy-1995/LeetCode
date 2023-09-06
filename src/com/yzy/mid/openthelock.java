package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/05 00:31
 * @Description 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 * @Version 1.0
 */
public class openthelock {
    public int openLock(String[] deadends, String target) {
        // 将deadends转换成Set，加快判断元素是否存在的速度
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));

        String start = "0000";
        if (deadendSet.contains(start)) return -1;
        if (start.equals(target)) return 0;

        // 定义起点和终点的Set
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        // 定义访问过的状态的Set
        Set<String> visitedSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(target);
        visitedSet.add(start);
        visitedSet.add(target);

        int step = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 从集合大小较小的一端进行扩展，能够减少搜索的深度和宽度，提高搜索效率
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String cur : beginSet) {
                List<String> nextLocks = getNextLock(cur);
                for (String nextLock : nextLocks) {
                    // 如果endSet中已经存在nextLock，说明双向BFS已经相遇，返回步数
                    if (endSet.contains(nextLock)) return step + 1;
                    if (!deadendSet.contains(nextLock) && !visitedSet.contains(nextLock)) {
                        nextSet.add(nextLock);
                        visitedSet.add(nextLock);
                    }
                }
            }
            beginSet = nextSet;
            step++;
        }
        return -1;
    }

    private List<String> getNextLock(String curLock) {
        List<String> nextLocks = new ArrayList<>();
        char[] curLockChars = curLock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = curLockChars[i];
            // 向上转动一格
            curLockChars[i] = (char) ((tmp - '0' + 1) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            // 向下转动一格
            curLockChars[i] = (char) ((tmp - '0' + 9) % 10 + '0');
            nextLocks.add(new String(curLockChars));
            // 恢复字符数组中的原始字符，方便下一次循环使用
            curLockChars[i] = tmp;
        }
        return nextLocks;

    }
}