package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/20 20:17
 * @Description
 * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
 *
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
 *
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
 * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
 * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 *
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
 *
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 或 "Dire" 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：senate = "RD"
 * 输出："Radiant"
 * 解释：
 * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
 * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
 * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
 * 示例 2：
 *
 * 输入：senate = "RDD"
 * 输出："Dire"
 * 解释：
 * 第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
 * 这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
 * 这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * @Version 1.0
 */
public class dota2Senate {
    public String predictPartyVictory(String senateStr) {
        // R = true表示本轮循环结束后，字符串里依然有R。D同理
        Boolean R = true, D = true;
        // 当flag大于0时，R在D前出现，R可以消灭D。当flag小于0时，D在R前出现，D可以消灭R
        int flag = 0;
        byte[] senate =  senateStr.getBytes();
        while (R && D) { // 一旦R或者D为false，就结束循环，说明本轮结束后只剩下R或者D了
            R = false;
            D = false;
            for (int i = 0; i < senate.length; i++) {
                if (senate[i] == 'R') {
                    if (flag < 0) senate[i] = 0; // 消灭R，R此时为false
                    else R = true; // 如果没被消灭，本轮循环结束有R
                    flag++;
                }
                if (senate[i] == 'D') {
                    if (flag > 0) senate[i] = 0;
                    else D = true;
                    flag--;
                }
            }
        }
        // 循环结束之后，R和D只能有一个为true
        return R == true ? "Radiant" : "Dire";
    }
}