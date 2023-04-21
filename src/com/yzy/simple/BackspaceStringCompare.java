package com.yzy.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: BackspaceStringCompare
 * Description:
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 示例 1：
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * @author Administrator
 * @date 2023-4-21 11:21
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab##", "c#d#"));
    }

    public boolean backspaceCompare(String s, String t) {
        List<Character> slist = new ArrayList<Character>();
        List<Character> tlist = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='#'){
                slist.add(s.charAt(i));
            }else {
                slist.remove(slist.size()-1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i)!='#'){
                tlist.add(t.charAt(i));
            }else {
                tlist.remove(tlist.size()-1);
            }
        }


        return Arrays.equals(slist.toArray(), tlist.toArray());
    }
}
