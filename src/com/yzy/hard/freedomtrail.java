package com.yzy.hard;

import java.util.Arrays;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.hard
 * @Date 2024/01/29 23:12
 * @Description
 * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
 *
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 *
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 *
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 *  对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 *  对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 *  当然, 我们还需要1步进行拼写。
 *  因此最终的输出是 4。
 * 示例 2:
 *
 * 输入: ring = "godding", key = "godding"
 * 输出: 13
 * @Version 1.0
 */
public class freedomtrail {
    int m, n;
    String ring, key;
    int[][] cache;
    public int findRotateSteps(String ring, String key) {
        m = ring.length();
        n = key.length();
        this.ring = ring;
        this.key = key;
        cache = new int[m][n];
        for(int[] p : cache) Arrays.fill(p, -1);
        return dfs(0, 0) + n;
    }
    // 以ring[i]为起点(12点方向)，在ring上找全key[j,n-1]所需要的最小移动步数。
    public int dfs(int i, int j){
        if(j == n) return 0;
        if(cache[i][j] != -1) return cache[i][j];
        // 1、ring[i] == key[j]对位相同时，视为取出ring[i]一次，key上指针j前进一步。
        if(ring.charAt(i) == key.charAt(j)){
            return dfs(i, j + 1);
        }
        // 2、对位不同时，分别从ring[i]左右两侧搜索最近的key[j]。
        // 在从ring[i]向右搜索key[j]。
        int right = 1;
        while(ring.charAt((i + right) % m) != key.charAt(j)){
            ++right;
        }
        // 从ring[i]向左搜索key[j]。
        int left = 1;
        while(ring.charAt((i - left + m) % m) != key.charAt(j)){
            ++left;
        }
        // 取ring两侧与i位最近的key[j]作为下一步落点，移动步数为二者距离。
        return cache[i][j] =  Math.min(dfs((i - left + m) % m , j + 1) + left, dfs((i + right) % m, j + 1) + right);
    }
}