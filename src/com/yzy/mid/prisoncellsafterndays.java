package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/14 18:15
 * @Description
 * 监狱中 8 间牢房排成一排，每间牢房可能被占用或空置。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行变更：
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * 注意：由于监狱中的牢房排成一行，所以行中的第一个和最后一个牢房不存在两个相邻的房间。
 *
 * 给你一个整数数组 cells ，用于表示牢房的初始状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0 。另给你一个整数 n 。
 *
 * 请你返回 n 天后监狱的状况（即，按上文描述进行 n 次变更）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cells = [0,1,0,1,1,0,0,1], n = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：下表总结了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * 示例 2：
 *
 * 输入：cells = [1,0,0,1,0,0,1,0], n = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 * @Version 1.0
 */
public class prisoncellsafterndays {
    int now =0;
    public int[] prisonAfterNDays(int[] cells, int n) {
        if(n==0) return cells;
        int x = n%14;
        if(x==0) x=14;
        while(x-->0){
            int[] tm = new int[8];
            tm[0]=0;tm[7]=0;
            for(int i = 1;i<7;i++){
                tm[i]=cells[i-1]==cells[i+1]?1:0;
            }
            cells=tm;
        }
        return cells;
    }
}