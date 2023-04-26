package com.yzy.simple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: DayoftheYear
 * Description:
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 解释：给定日期是2019年的第九天。
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * @author Administrator
 * @date 2023-4-26 14:19
 */
public class DayoftheYear {
    public static void main(String[] args) {
        System.out.println(new DayoftheYear().dayOfYear("2019-02-10"));
    }

    public int dayOfYear(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.getDayOfYear();
    }
}
