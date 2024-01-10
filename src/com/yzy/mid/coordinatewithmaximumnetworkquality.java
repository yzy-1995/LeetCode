package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2024/01/10 00:37
 * @Description
 * 给你一个数组 towers 和一个整数 radius 。
 *
 * 数组  towers  中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 *
 * 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius 以外的距离该塔是 不能到达的 。
 *
 * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能到达 该坐标的塔的信号强度之和。
 *
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点 (cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 *
 * 注意：
 *
 * 坐标 (x1, y1) 字典序比另一个坐标 (x2, y2) 小，需满足以下条件之一：
 * 要么 x1 < x2 ，
 * 要么 x1 == x2 且 y1 < y2 。
 * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
 * 输出：[2,1]
 * 解释：
 * 坐标 (2, 1) 信号强度之和为 13
 * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
 * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
 * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
 * 没有别的坐标有更大的信号强度。
 * 示例 2：
 *
 * 输入：towers = [[23,11,21]], radius = 9
 * 输出：[23,11]
 * 解释：由于仅存在一座信号塔，所以塔的位置信号强度最大。
 * 示例 3：
 *
 * 输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
 * 输出：[1,2]
 * 解释：坐标 (1, 2) 的信号强度最大。
 * @Version 1.0
 */
public class coordinatewithmaximumnetworkquality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xmin = 0, xmax = 0, ymin = 0, ymax = 0;
        for(int[] t: towers){
            xmin = Math.min(xmin, t[0]);
            xmax = Math.max(xmax, t[0]);
            ymin = Math.min(ymin, t[1]);
            ymax = Math.max(ymax, t[1]);
        }

        int r2 = radius * radius;
        int strongest = Integer.MIN_VALUE, strongestX = Integer.MIN_VALUE, strongestY = Integer.MIN_VALUE;
        for(int x = xmin - radius + 1; x < xmax + radius; x++){
            if(x < 0)continue;
            for(int y = ymin - radius + 1; y < ymax + radius; y++){
                if(y < 0)continue;
                int quality = 0;
                for(int[] t: towers){
                    int dis2 = (t[0] - x) * (t[0] - x) + (t[1] - y) * (t[1] - y);
                    if(dis2 <= r2)quality += Math.floor(t[2] / (1 + Math.sqrt(dis2)));
                }
                // if(x == 34 && y == 22)System.out.printf("%s, %s, %s, %s\n", x, y, quality, strongest);
                if(quality > strongest){
                    strongest = quality;
                    strongestX = x;
                    strongestY = y;
                }
                // 因为我们在迭代的时候，x和y都是递增的，所以quality = strongest的情况，已经被自动处理好了。
            }
        }
        return new int[]{strongestX, strongestY};
    }
}