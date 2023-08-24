package com.yzy.mid;

import java.util.ArrayList;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/23 00:04
 * @Description
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 *
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * 示例 2：
 *
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * @Version 1.0
 */
public class beautifularrangementii {
    public int[] constructArray(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= k; ++i) list.add(i);
        int[] result = new int[n];
        for (int i = k; i < n; ++i) result[i] = i + 1;
        for (int i = k - 1; i >= 0; --i)
            if (list.remove(new Integer(result[i + 1] + i + 1))) result[i] = result[i + 1] + i + 1;
            else if (list.remove(new Integer(result[i + 1] - i - 1))) result[i] = result[i + 1] - i - 1;
        return result;
    }
}