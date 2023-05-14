package com.yzy.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Description: lcs03
 *
 * @author yzy15
 * @date 2023/05/13 15:24
 **/
public class lcs03 {
    public int halfQuestions(int[] questions) {
        int N = questions.length/2;
        int count = 0;
        // 创建map集合，题目类型作为key，每种类型的数量作为value
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            int key = questions[i];
            // 如果map集合中已经存放过对应类型的题目，则将其对应的value加一
            if (hash.containsKey(key)) {
                int value = hash.get(key);
                hash.put(key, ++value);
            }else {
                hash.put(key, 1);
            }
        }
        Set<Entry<Integer, Integer>> entrySet = hash.entrySet();
        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer,Integer>>(entrySet);
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        int typeNum = 0;
        for (Entry<Integer, Integer> entry : list) {
            typeNum++;
            count = count + entry.getValue();
            if(count >= N) {
                break;
            }
        }
        return typeNum;
    }
}
