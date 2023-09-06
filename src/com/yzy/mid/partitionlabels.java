package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/06 00:07
 * @Description
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 *
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * @Version 1.0
 */
public class partitionlabels {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int lastIndex = s.lastIndexOf(chars[i]);
            if (lastIndex > end) {
                // 遇到更远的end就替换
                end = lastIndex;
            }
            // 到达前面字符的最远下标点，就计算一次长度
            if (end == i) {
                res.add(end - start + 1);
                // 区间进入滑动
                start = i + 1;
            }
        }
        return res;
    }
}