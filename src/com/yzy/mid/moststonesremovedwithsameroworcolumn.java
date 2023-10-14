package com.yzy.mid;

import java.util.HashSet;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/12 00:09
 * @Description
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 * @Version 1.0
 */
public class moststonesremovedwithsameroworcolumn {
    public int removeStones(int[][] stones) {
        int[] father = new int[stones.length];
        //初始化 自己是自己的上级
        for(int i=0; i<stones.length; i++){
            father[i] = i;
        }

        //查询 合并
        for(int i=0; i<stones.length; i++){
            for(int j=i+1; j<stones.length; j++){
                int x1 = stones[i][0];
                int y1 = stones[i][1];
                int x2 = stones[j][0];
                int y2 = stones[j][1];
                if(x1 == x2 || y1 == y2){
                    union(father, i, j);
                }
            }
        }

        //计算连通分量个数 hash数据结构查询快 set没有重复元素
        HashSet<Integer> res = new HashSet<>();
        for(int i=0; i<father.length; i++){
            res.add(findFather(father, i));
        }
        //结果= 所有石头数 - 连通分量个数
        return stones.length - res.size();
    }

    //合并连通分量
    public void union(int[] father, int x, int y){
        int xFather = findFather(father, x);
        int yFather = findFather(father ,y);
        if(xFather != yFather){
            father[xFather] = yFather;
        }
    }

    //找上级
    public int findFather(int[] father, int x){
        while(father[x] != x){
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }
}