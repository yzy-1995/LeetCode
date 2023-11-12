package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/11 15:19
 * @Description
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 * 示例 2：
 *
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 * @Version 1.0
 */
public class pathwithmaximumgold {
    int ans=0;
    int grid[][];
    public int getMaximumGold(int[][] grid) {
        this.grid=grid;
        for(int i=0;i<grid.length;i++){for(int j=0;j<grid[0].length;j++){if(grid[i][j]>0){getGold(i,j,0);}}}
        return ans;
    }
    public void getGold(int i,int j,int gold){
        if(i==-1||j==-1||i==grid.length||j==grid[0].length||grid[i][j]==0){return;}
        int g=grid[i][j];
        gold+=g;
        grid[i][j]=0;
        ans=Math.max(ans,gold);
        getGold(i+1,j,gold);
        getGold(i-1,j,gold);
        getGold(i,j+1,gold);
        getGold(i,j-1,gold);
        gold-=g;
        grid[i][j]=g;
    }
}