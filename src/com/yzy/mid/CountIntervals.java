package com.yzy.mid;

import java.util.TreeMap;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/16 00:12
 * @Description
 * 给你区间的 空 集，请你设计并实现满足要求的数据结构：
 *
 * 新增：添加一个区间到这个区间集合中。
 * 统计：计算出现在 至少一个 区间中的整数个数。
 * 实现 CountIntervals 类：
 *
 * CountIntervals() 使用区间的空集初始化对象
 * void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
 * int count() 返回出现在 至少一个 区间中的整数个数。
 * 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
 *
 *
 *
 * 示例 1：
 *
 * 输入
 * ["CountIntervals", "add", "add", "count", "add", "count"]
 * [[], [2, 3], [7, 10], [], [5, 8], []]
 * 输出
 * [null, null, null, 6, null, 8]
 *
 * 解释
 * CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
 * countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
 * countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
 * countIntervals.count();    // 返回 6
 *                            // 整数 2 和 3 出现在区间 [2, 3] 中
 *                            // 整数 7、8、9、10 出现在区间 [7, 10] 中
 * countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
 * countIntervals.count();    // 返回 8
 *                            // 整数 2 和 3 出现在区间 [2, 3] 中
 *                            // 整数 5 和 6 出现在区间 [5, 8] 中
 *                            // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
 *                            // 整数 9 和 10 出现在区间 [7, 10] 中
 * @Version 1.0
 */
public class CountIntervals {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int ans = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        Integer L = map.floorKey(right);
        int l = left, r = right;
        while (L != null && map.get(L) >= l) {
            l = Math.min(l, L);
            r = Math.max(r, map.get(L));
            ans -= (map.get(L) - L + 1);
            map.remove(L);
            L = map.floorKey(right);
        }
        ans += (r - l + 1);
        map.put(l, r);
    }

    public int count() {
        return ans;
    }
}