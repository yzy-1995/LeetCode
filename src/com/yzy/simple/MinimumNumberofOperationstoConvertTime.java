package com.yzy.simple;

/**
 * Description: leetcode2224
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * 示例 1：
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 * 示例 2：
 * 输入：current = "11:00", correct = "11:01"
 * 输出：1
 * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
 * @author yzy15
 * @date 2023/05/07 08:55
 **/
public class MinimumNumberofOperationstoConvertTime {
    public static void main(String[] args) {

    }

    public int convertTime(String current, String correct) {
        char[] cu = current.toCharArray();
        char[] co = correct.toCharArray();
        int res = 0;
        int cuH = (cu[0] - '0') * 10 + (cu[1] - '0');
        int coH = (co[0] - '0') * 10 + (co[1] - '0');
        int cuM = (cu[3] - '0') * 10 + (cu[4] - '0');
        int coM = (co[3] - '0') * 10 + (co[4] - '0');
        int subM = (coH - cuH) * 60 + (coM - cuM);
        int[] times = new int[]{60, 15, 5, 1};
        for (int time : times) {
            res += subM / time;
            subM %= time;
        }
        return res;
    }
}
