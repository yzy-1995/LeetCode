package com.yzy.simple;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 * Description: leetcode1360
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 *
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 * @author yzy15
 * @date 2023/04/29 10:44
 **/
public class NumberofDaysBetweenTwoDates {
    public static void main(String[] args) {

    }

    public int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        return (int) Math.abs(ChronoUnit.DAYS.between(localDate1, localDate2));
    }
}
