package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/28 00:06
 * @Description
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 *
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 *
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * @Version 1.0
 */
public class MagicalString {
    public int magicalString(int n) {
        StringBuilder str = new StringBuilder("122");
        int res = 1;
        char num = '2';
        //最少拼接n次
        for (int i = 2; i < n; i++) {
            //当前位置的值
            int cnt = str.charAt(i) - '0';
            //遍历过程中进行计算1的数量
            if (cnt == 1) res++;
            //要添加到末尾的值，1与2交替
            num = num == '2' ? '1' : '2';
            //添加到末尾cnt次
            for (int j = 1; j <= cnt; j++) {
                str.append("" + num);
            }
        }
        //System.out.println(str.toString());
        return res;
    }
}