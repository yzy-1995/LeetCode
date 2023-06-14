package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CombinationSumIII
 * Description:
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 *
 * @author Administrator
 * @date 2023-6-12 9:58
 */
public class CombinationSumIII {
    List<Integer> arr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(0, n, k, 1);
        return res;
    }

    private void backTracking(int sum, int n, int k, int startIndex) {
        if (sum == n && arr.size() == k) res.add(new ArrayList<>(arr));
        for (int i = startIndex; i <= 9; i++) {
            arr.add(i);
            sum += i;
            backTracking(sum, n, k, i + 1);
            sum -= i;
            arr.remove(arr.size() - 1);
        }
    }
}
