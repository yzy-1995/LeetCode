package com.yzy.mid;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: leetcode18
 *
 * @author yzy15
 * @date 2023/05/20 22:40
 **/
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        LinkedList<List<Integer>> list = new LinkedList<>();
        HashMap<Object, Object> map1 = new HashMap<>();
        HashMap<Object, Object> map3 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int i2 = nums[i] + nums[i1];


                List<String> orDefault = map.get(i2);
                if (orDefault == null) {
                    orDefault = new LinkedList<>();
                    orDefault.add(i + "," + i1);
                    map.put(i2, orDefault);
                } else {
                    boolean fla = true;
                    int sum = 0;
                    for (String s : orDefault) {
                        String[] split = s.split(",");

                        if (
                                (nums[Integer.parseInt(split[0])] == nums[i] ||
                                        nums[Integer.parseInt(split[1])] == nums[i]) &&
                                        (nums[Integer.parseInt(split[0])] == nums[i1] ||
                                                nums[Integer.parseInt(split[1])] == nums[i1])

                        ) {
                            sum++;
                        }
                        if (sum >= 200) {
                            fla = !fla;
                            break;
                        }


                    }
                    if (fla)
                        orDefault.add(i + "," + i1);

                }
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer i2 = entry.getKey();
            if (map3.containsKey(i2)) continue;
            List<String> value = entry.getValue();
            map3.put(i2, 1);
            int diff = target - i2;
            if (((target ^ i2) & (target ^ diff)) < 0) {
                // 发生溢出
                continue;
            }
            if (map.containsKey(target - i2)) {
                map3.put(target - i2, 1);
                for (String s_Str : value) {
                    String[] split2 = s_Str.split(",");
                    int i = Integer.parseInt(split2[0]);
                    int i1 = Integer.parseInt(split2[1]);


                    List<String> list1 = map.get(target - i2);
                    for (String s : list1) {
                        String[] split = s.split(",");

                        if (
                                Integer.parseInt(split[0]) == i
                                        || Integer.parseInt(split[0]) == i1
                                        || Integer.parseInt(split[1]) == i
                                        || Integer.parseInt(split[1]) == i1

                        ) continue;
                        int[] ints = new int[4];
                        ints[0] = nums[Integer.parseInt(split[0])];
                        ints[1] = nums[Integer.parseInt(split[1])];
                        ints[2] = nums[i];
                        ints[3] = nums[i1];
                        Arrays.sort(ints);
                        String s1 = Arrays.toString(ints);
                        if (map1.containsKey(s1)) {
                            continue;
                        }
                        map1.put(s1, 1);
                        list.add(IntStream.of(ints).boxed().collect(Collectors.toList()));
                    }
                }
            }

        }
        return list;
    }
}
