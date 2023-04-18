package com.yzy.simple;


/**
 * ClassName: CountDaysSpentTogether
 * Description: leetcode2409
 * Alice 和 Bob 计划分别去罗马开会。
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob
 * 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
 * 而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。
 * 每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * 示例 1：
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，
 * 他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * 示例 2：
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * @author Administrator
 * @date 2023-4-17 9:57
 */
public class CountDaysSpentTogether {
    public static void main(String[] args) {
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        int days = new CountDaysSpentTogether().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(days);
    }


//    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
//        LocalDate start = LocalDate.parse(arriveAlice, formatter).withYear(2000);
//        LocalDate end = LocalDate.parse(leaveBob, formatter).withYear(2000);
//        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        int count = 0;
//        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
//            int month = date.getMonthValue() - 1;
//            int day = date.getDayOfMonth() - 1;
//            if (date.isAfter(LocalDate.parse(arriveBob, formatter).withYear(2000).minusDays(1))
//                    && date.isBefore(LocalDate.parse(leaveAlice, formatter).withYear(2000).plusDays(1))
//                    && day == month && day < daysInMonth[month]) {
//                count++;
//            }
//        }
//        return count;
//
//    }

    /**
     * 1.首先，我们创建一个数组 daysInMonth 来表示每个月的天数，这里假设不是闰年，所以二月份有28天。
     * 2.然后，我们需要将输入的字符串格式的日期转换为从年初开始的天数，这样我们可以更容易地比较日期。
     * 为此，我们创建了一个名为 getDateAsInt 的辅助方法，它接受一个日期字符串和 daysInMonth 数组。
     * 这个方法首先解析出月份和天数，然后计算从年初到给定日期的总天数。
     * 3.对于 Alice 和 Bob 的到达和离开日期，我们调用 getDateAsInt 方法，将它们转换为从年初开始的天数。
     * 4.为了找出 Alice 和 Bob 在罗马的时间范围的交集，我们需要找到交集的开始和结束日期。
     * 交集的开始日期是 Alice 和 Bob 的到达日期中的较大值，交集的结束日期是 Alice 和 Bob 的离开日期中的较小值。
     * 5.接下来，我们计算交集的天数。为了防止出现负数（即没有交集的情况），我们使用 Math.max(0, end - start + 1)
     * 计算交集的天数。如果 end - start + 1 为负数，表示没有交集，我们返回0。否则，返回实际的天数。
     * @param arriveAlice
     * @param leaveAlice
     * @param arriveBob
     * @param leaveBob
     * @return
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArrive = getDateAsInt(arriveAlice, daysInMonth);
        int aliceLeave = getDateAsInt(leaveAlice, daysInMonth);
        int bobArrive = getDateAsInt(arriveBob, daysInMonth);
        int bobLeave = getDateAsInt(leaveBob, daysInMonth);

        int start = Math.max(aliceArrive, bobArrive);
        int end = Math.min(aliceLeave, bobLeave);

        return Math.max(0, end - start + 1);
    }

    private int getDateAsInt(String date, int[] daysInMonth) {
        int month = Integer.parseInt(date.substring(0, 2)) - 1;
        int day = Integer.parseInt(date.substring(3, 5));
        int totalDays = 0;

        for (int i = 0; i < month; i++) {
            totalDays += daysInMonth[i];
        }

        totalDays += day;
        return totalDays;
    }
}
