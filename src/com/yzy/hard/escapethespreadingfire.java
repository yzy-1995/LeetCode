package com.yzy.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2023/11/09 00:02
 * @Description
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
 *
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
 *
 * 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 109 。
 *
 * 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
 *
 * 如果两个格子有共同边，那么它们为 相邻 格子。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
 * 输出：3
 * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 * 你仍然可以安全到达安全屋。
 * 停留超过 3 分钟会让你无法安全到达安全屋。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 * 输出：-1
 * 解释：上图展示了你马上开始朝安全屋移动的情形。
 * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 * 所以返回 -1 。
 * 示例 3：
 *
 *
 *
 * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 * 输出：1000000000
 * 解释：上图展示了初始网格图。
 * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 * 所以返回 109 。
 * @Version 1.0
 */
public class escapethespreadingfire {
    int[][] g;
    int m, n;
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maximumMinutes(int[][] g) {
        this.g = g;
        m = g.length;
        n = g[0].length;
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] vis = new boolean[m][n];
        // 预处理矩阵，将所有墙壁点标记为-1，这样就可以用0代表空地，以及大于0的数字代表每个位置开始着火的时间。
        // 将初始火源点存入队列，后续bfs按圈扩张，标记所有
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(g[i][j] == 2){
                    g[i][j] = -1;
                }else if(g[i][j] == 1){
                    que.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        int time = 1;
        // bfs分层模拟扩展随时间可被火焰蔓延的区域,在g矩阵标记着火时间点,time最终为火焰铺满所有可蔓延位置所需的时间。
        while(!que.isEmpty()){
            int len = que.size();
            while(--len >= 0){
                int[] p = que.poll();
                for(int k = 0; k < 4; ++k){
                    int i = p[0] + dir[k][0], j = p[1] + dir[k][1];
                    if(i >= 0 && j >= 0 && i < m && j < n && !vis[i][j] && g[i][j] == 0){
                        g[i][j] = time;
                        que.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
            ++time;
        }
        // 二分找到无法到达的最小暂停时间r，则r-1即为最大可暂停时间。
        int l = 0, r = time;
        while(l < r){
            int mid = l + r >> 1;
            if(!bfs(mid))
                r = mid;
            else
                l = mid + 1;
        }
        // 若直接出发仍无法到达，则-1不可实现；若火焰完成扩张后+1秒仍可到达，因火焰不会在扩张，所以说明后续仍可到达。
        // 否则返回最小无法到达暂停时间r-1即可。
        if(r == 0)
            return -1;
        else if(r == time)
            return 1000000000;
        else
            return r-1;
    }
    // bfs验证在预留t时间的火势状态下，是否能够从左上角走到右下角。
    public boolean bfs(int t){
        ++t;
        boolean[][] vis = new boolean[m][n];
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0,0});
        vis[0][0] = true;
        // 当
        while(!que.isEmpty()){
            int len = que.size();
            while(len-- > 0){
                int[] p = que.poll();
                for(int k = 0; k < 4; ++k){
                    int i = p[0] + dir[k][0], j = p[1] + dir[k][1];
                    if(i >= 0 && j >= 0 && i < m && j < n && !vis[i][j] && (g[i][j] >= t || g[i][j] == 0)){
                        // 到达终点(m-1,n-1)则true。
                        if(i == m - 1 && j == n - 1)
                            return true;
                        if(g[i][j] > t || g[i][j] == 0)
                            que.offer(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
            // 若中途终点被火蔓延,则后续也无法再到达,直接false。
            if(g[m-1][n-1] == t)
                return false;
            ++t;
        }
        return false;
    }
}