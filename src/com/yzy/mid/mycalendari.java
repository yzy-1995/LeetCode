package com.yzy.mid;

import java.util.TreeSet;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/02 23:53
 * @Description
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 *
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 *
 * 实现 MyCalendar 类：
 *
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 *
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * @Version 1.0
 */
public class mycalendari {
    TreeSet<int[]> calendars;

    public mycalendari() {
        calendars = new TreeSet<>((a, b) -> {
            if(a[1] <= b[0])
                return -1;
            else if(a[0] >= b[1])
                return 1;
            else
                return 0;
        });
    }

    public boolean book(int start, int end) {
        int[] e = new int[]{start, end};
        return calendars.add(e);
    }
}