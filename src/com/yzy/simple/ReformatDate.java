package com.yzy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode1507
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 [1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * 示例 1：
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 * @author yzy15
 * @date 2023/04/30 03:21
 **/
public class ReformatDate {
    public static void main(String[] args) {

    }

    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String day = parts[0].replaceAll("[^\\d]", "");
        if (day.length() == 1) {
            day = "0" + day;
        }

        return parts[2] + "-" + months.get(parts[1]) + "-" + day;

    }
}
