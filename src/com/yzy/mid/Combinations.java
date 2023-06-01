package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Combinations
 * Description:
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * @author Administrator
 * @date 2023-5-24 14:05
 */
public class Combinations {

    List<List<Integer>> listTotal = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrace(n, k, new ArrayList<Integer>(), 1);
        return listTotal;
    }

    private void backtrace(int n, int k, ArrayList<Integer> list, int i) {
        if (list.size() == k) {
            listTotal.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrace(n, k, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
