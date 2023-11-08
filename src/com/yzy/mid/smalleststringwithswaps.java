package com.yzy.mid;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/08 22:13
 * @Description
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * @Version 1.0
 */
public class smalleststringwithswaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        int[] p = new int[length];
        //并查集数组初始化，每个元素都是自己的父节点
        for (int i = 0; i < length; i++){
            p[i] = i;
        }
        //pairs数组中合并，看成一个集合
        for (List<Integer> pair : pairs){
            union(pair.get(0), pair.get(1), p);
        }
        //建立集合和优先队列对应哈希表
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        //对于每一个字符串下标i，首先找到它对应的集合（父节点），并且建立对应的优先队列，并把S[i]字符储存进优先队列
        for (int i = 0; i < length; i++){
            int cur = find(i, p);
            if (!map.containsKey(cur)){
                map.put(cur, new PriorityQueue<>());
            }
            map.get(cur).offer(s.charAt(i));
        }
        //建立字符串，把对应下标所在集合对应的优先队列中的char一个个加入字符串中
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            sb.append(map.get(find(i, p)).poll());
        }
        return sb.toString();

    }
    public int find(int x, int[] p){
        if (p[x] != x){
            p[x] = find(p[x], p);
        }
        return p[x];
    }
    public void union(int x, int y, int[] p){
        int px = find(x, p);
        int py = find(y, p);
        if (px != py){
            p[px] = py;
        }
    }
}