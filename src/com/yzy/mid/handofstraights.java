package com.yzy.mid;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/22 11:17
 * @Description
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌上的数值。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * @Version 1.0
 */
public class handofstraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        if (groupSize == 1) return true;
        Arrays.sort(hand);
        // 模拟时用于存储每一组的数字,0储存当前组的最大元素，1存储当前组的元素数量
        int[][] result = new int[hand.length/groupSize][2];
        //now代表当前正要填充的组，next代表下一次出现重复数字时，要将其放入的组
        int now = 0, next = 1;
        for (int i = 0; i < hand.length; i++){
            //当前组没有元素，发现元素直接填入并重置next
            if (result[now][1] == 0){
                result[now][1]++;
                result[now][0] = hand[i];
                next = now + 1;
                continue;
            }
            //发现与当前组顶上元素相同的元素，将其放入next作为缓冲
            if (result[now][0] == hand[i]){
                if (next == result.length) return false;
                result[next][0] = hand[i];
                result[next][1] ++;
                next++;
            }else {
                //当前元素与now的顶上元素不同时，如果不是其加一后的值则直接失败
                if (result[now][0] + 1 != hand[i]) return false;
                //填入 now
                result[now][1]++;
                result[now][0] = hand[i];
                if (result[now][1] == groupSize) now++;
                next = now + 1;
            }
        }
        return now == hand.length/groupSize;
    }
}