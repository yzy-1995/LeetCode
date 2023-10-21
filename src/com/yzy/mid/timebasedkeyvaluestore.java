package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/19 00:21
 * @Description
 * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
 *
 * 实现 TimeMap 类：
 *
 * TimeMap() 初始化数据结构对象
 * void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
 * String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
 *
 * 示例 1：
 *
 * 输入：
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * 输出：
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 *
 * 解释：
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
 * timeMap.get("foo", 1);         // 返回 "bar"
 * timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
 * timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
 * timeMap.get("foo", 4);         // 返回 "bar2"
 * timeMap.get("foo", 5);         // 返回 "bar2"
 * @Version 1.0
 */
public class timebasedkeyvaluestore {
    class Pair{
        int timestamp;
        String value;

        public Pair(int timestamp,String value){
            this.timestamp=timestamp;
            this.value=value;
        }
    }
    Map<String, List<Pair>> map;
    public timebasedkeyvaluestore() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        //key对应一个列表，因为同一个key会有多个不同value
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(timestamp,value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> pairs=map.get(key);

        //二分查找
        int left=0,right=pairs.size()-1,mid,pos=-1;
        while(left<=right){
            mid=left+(right-left)/2;
            int t=pairs.get(mid).timestamp;
            String v=pairs.get(mid).value;
            if(timestamp<t){
                right=mid-1;
            }else{
                left=mid+1;
                pos=mid;
            }
        }
        return pos==-1?"":pairs.get(pos).value;
    }
}