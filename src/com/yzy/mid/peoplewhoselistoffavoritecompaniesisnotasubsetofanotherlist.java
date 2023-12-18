package com.yzy.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/17 00:16
 * @Description
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 *
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 * @Version 1.0
 */
public class peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist {
    public List<Integer> peopleIndexes(List<List<String>> comps) {
        List<Integer> res = new ArrayList<>();
        int len = comps.size();

        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (i == j || comps.get(i).size() >= comps.get(j).size()) {
                    continue;
                }
                flag = new HashSet<>(comps.get(j)).containsAll(comps.get(i));
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                res.add(i);
            }
        }

        return res;
    }
}