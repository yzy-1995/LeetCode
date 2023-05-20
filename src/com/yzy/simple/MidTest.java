package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 啊
 *
 * @author yzy15
 * @date 2023/05/15 23:16
 **/
public class MidTest {

    public static void main(String[] args) {
        System.out.println(test(new String[]{"abc", "aaa", "aba", "bab"}, "bbb"));
    }
    public static int test(String[] inputArray, String result) {
        List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i+1; j < inputArray.length; j++) {
                if (!inputArray[i].equals(inputArray[j])) {
                    String[] pair = {inputArray[i], inputArray[j]};
                    pairs.add(pair);
                }
            }
        }

        int count = 0;
        for (String[] pair : pairs) {
            boolean canProduceResult = true;
            for (int i = 0; i < result.length(); i++) {
                if (pair[0].charAt(i) == pair[1].charAt(i)) {
                    if (!(result.charAt(i) == pair[0].charAt(i) || result.charAt(i) == pair[1].charAt(i))) {
                        canProduceResult = false;
                        break;
                    }
                } else {
                    if (result.charAt(i) != pair[0].charAt(i) && result.charAt(i) != pair[1].charAt(i)) {
                        canProduceResult = false;
                        break;
                    }
                }
            }
            if (canProduceResult) {
                count++;
            }
        }

        return count;
    }
}
