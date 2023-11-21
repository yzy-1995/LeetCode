package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/21 16:15
 * @Description
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 *
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 *
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 *
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0（绿色），你的朋友包括（黄色）：
 * id 为 1 -> watchedVideos = ["C"]
 * id 为 2 -> watchedVideos = ["B","C"]
 * 你朋友观看过视频的频率为：
 * B -> 1
 * C -> 2
 * 示例 2：
 *
 *
 *
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0（绿色），你朋友的朋友只有一个人，他的 id 为 3（黄色）。
 * @Version 1.0
 */
public class getwatchedvideosbyyourfriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList();
        q.offer(id);
        // 不走回头路
        HashSet<Integer> hs = new HashSet();
        while(level-- > 0){
            int size = q.size();

            while(size-- > 0){
                id = q.poll();
                hs.add(id);
                for(int i:friends[id]){
                    if(!hs.contains(i)){
                        hs.add(i);
                        q.offer(i);
                    }
                }
            }
        }

        //  将最后一层的视频放入hm
        HashMap<String, Integer> hm = new HashMap();
        while(!q.isEmpty()){
            id = q.poll();
            for(String s:watchedVideos.get(id)){
                int value = hm.getOrDefault(s, 0) + 1;
                hm.put(s, value);
            }
        }

        //排序
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue() > e2.getValue()){
                    return 1;
                }else if(e1.getValue() < e2.getValue()){
                    return -1;
                }else{
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        });



        List<String> ret = new ArrayList();
        for(Map.Entry<String, Integer> e : list){
            ret.add(e.getKey());
        }

        return ret;
    }
}