package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: RestoreIpAddresses
 * Description:
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * @author Administrator
 * @date 2023-5-25 15:26
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        new RestoreIpAddresses().restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<String>(), 0);
        return res;
    }

    private void backtrack(String s, List<String> res, ArrayList<String> segments, int start) {
        if (segments.size() == 4) {
            if (start == s.length()) {
                res.add(String.join(".", segments));
            }
            return;
        }
        if (start == s.length()) {
            return;
        }
        if (s.charAt(start) == '0') {
            segments.add("0");
            backtrack(s, res, segments, start + 1);
            segments.remove(segments.size() - 1);
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String segment = s.substring(start, start + i);
            int num = Integer.parseInt(segment);
            if (num >= 0 && num <= 255) {
                segments.add(segment);
                backtrack(s, res, segments, start + i); // Change start + 1 to start + i
                segments.remove(segments.size() - 1);
            }
        }
    }
}
