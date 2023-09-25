package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/09/26 00:16
 * @Description
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 *
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 *
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 *
 *
 * 示例 1：
 *
 *
 * 输入：p = 2, q = 1
 * 输出：2
 * 解释：这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 * 示例 2：
 *
 * 输入：p = 3, q = 1
 * 输入：1
 * @Version 1.0
 */
public class mirrorreflection {
    public int mirrorReflection(int p, int q) {
        if(q==0)return 0;
        int t=1;
        while ((p*t) % q != 0) {
            t++;
        }
        return (p*t/q)%2==0?2:t%2;
    }
}