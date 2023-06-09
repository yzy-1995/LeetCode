package com.yzy.simple;

import javax.security.auth.login.CredentialNotFoundException;

/**
 * ClassName: QuickComputingRobot
 * Description:
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，
 * 小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，
 * 字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 *
 * @author Administrator
 * @date 2023-3-27 13:51
 */
public class QuickComputingRobot {
    public static void main(String[] args) {
        QuickComputingRobot quickComputingRobot = new QuickComputingRobot();
        System.out.println(quickComputingRobot.calculate("AB"));
    }
    public int calculate(String s) {
        int start=1,end=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A'){
                start = startMethod(start,end);
            } else if (s.charAt(i) == 'B') {
                end = endMethod(start,end);
            }
        }
        return start+end;
    }
    public int startMethod(int x, int y) {
        return 2*x+y;
    }
    public int endMethod(int x, int y) {
        return 2*y+x;
    }
}
