package com.yzy.mid;

import java.util.LinkedList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/09 00:13
 * @Description
 * @Version 1.0
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        if(n == Integer.MAX_VALUE) return -1;
        LinkedList<Integer> t = new LinkedList<>();
        while (n != 0) {
            t.addFirst(n % 10);
            n = n / 10;
        }

        for (int i = t.size() - 2; i >= 0; --i) {
            if (t.get(i) < t.get(i + 1)) {
                //调整i位置即可
                //向后找比i大的 最小的数的位置 交换
                int targetIndex = i + 1;
                for (int j = i + 1; j < t.size(); ++j) {
                    if (t.get(j) > t.get(i) && t.get(j) <= t.get(targetIndex)) {
                        targetIndex = j;
                    }
                }
                swap(t, i, targetIndex);

                //调整从i+1开始到结尾的顺序 [i+1,t.size()-1] 依次递增 保证最小
                int l =i+1,r=t.size()-1;
                while(l<r){
                    swap(t,l++,r--);
                }


                //判断一下调整完之后是不是越界了
                long res = 0;
                for (int k = 0; k < t.size(); ++k) {
                    res = res * 10 + t.get(k);
                }
                if(res >Integer.MAX_VALUE) return -1;

                return (int)res;

            }
        }

        return -1;
    }

    private void swap(LinkedList<Integer> t, int a, int b) {
        int tmp = t.get(a);
        t.set(a, t.get(b));
        t.set(b, tmp);
    }
}