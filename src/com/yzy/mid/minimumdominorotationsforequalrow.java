package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/24 01:13
 * @Description
 * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 *
 * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
 *
 * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
 *
 * 如果无法做到，返回 -1.
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * 示例 2：
 *
 * 输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * 输出：-1
 * 解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 * @Version 1.0
 */
public class minimumdominorotationsforequalrow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int tt = 0, tb = 0, bt = 0, bb = 0;
        boolean tf = false, bf = false;
        for (int i = 0; i < tops.length; i++){
            if (tops[i] != tops[0] && bottoms[i] != tops[0]) tf = true;
            if (tops[i] != bottoms[0] && bottoms[i] != bottoms[0]) bf = true;
            tt += tops[i] == tops[0] ? 1 : 0;
            tb += bottoms[i] == tops[0] ? 1 : 0;
            bt += tops[i] == bottoms[0] ? 1 : 0;
            bb += bottoms[i] == bottoms[0] ? 1 : 0;
        }
        if (tf && bf) return -1;
        return tops.length - Math.max(tf ? -1 :Math.max(tt,tb),bf ? -1 : Math.max(bt,bb));
    }
}