package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/21 00:03
 * @Description
 * 给定一个数字字符串 num，比如 "123456579"，我们可以将它分成「斐波那契式」的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式 序列是一个非负整数列表 f，且满足：
 *
 * 0 <= f[i] < 231 ，（也就是说，每个整数都符合 32 位 有符号整数类型）
 * f.length >= 3
 * 对于所有的0 <= i < f.length - 2，都有 f[i] + f[i + 1] = f[i + 2]
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 num 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = "1101111"
 * 输出：[11,0,11,11]
 * 解释：输出[110,1,111]也可以。
 * 示例 2：
 *
 * 输入: num = "112358130"
 * 输出: []
 * 解释: 无法拆分。
 * 示例 3：
 *
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * @Version 1.0
 */
public class splitarrayintofibonaccisequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        return backTrack(S, ans, 0) ? ans : new ArrayList<>();
    }

    private boolean backTrack(String S, List<Integer> ans, int start) {
        if (ans.size() >= 3) {
            int num = ans.size();
            //不满足斐波那契
            if (ans.get(num - 1) != ans.get(num - 2) + ans.get(num - 3)) {
                return false;
            }
        }
        if (start == S.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = start + 1; i <= S.length(); i++) {
            String tmp = S.substring(start, i);
            //当前数字以0开头但不是0，返回false
            if (tmp.charAt(0) == '0' && !"0".equals(tmp)) {
                break;
            }
            long num = Long.parseLong(tmp);
            //当前数字超过int的范围，返回false
            if (num > Integer.MAX_VALUE) {
                break;
            }
            ans.add((int) num);
            if (backTrack(S, ans, i)) {
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}