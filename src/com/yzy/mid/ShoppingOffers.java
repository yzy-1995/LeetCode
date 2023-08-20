package com.yzy.mid;

import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/08/17 00:05
 * @Description
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。
 *
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 *
 * 返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
 *
 *
 *
 * 示例 1：
 *
 * 输入：price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
 * 输出：14
 * 解释：有 A 和 B 两种物品，价格分别为 ¥2 和 ¥5 。
 * 大礼包 1 ，你可以以 ¥5 的价格购买 3A 和 0B 。
 * 大礼包 2 ，你可以以 ¥10 的价格购买 1A 和 2B 。
 * 需要购买 3 个 A 和 2 个 B ， 所以付 ¥10 购买 1A 和 2B（大礼包 2），以及 ¥4 购买 2A 。
 * 示例 2：
 *
 * 输入：price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
 * 输出：11
 * 解释：A ，B ，C 的价格分别为 ¥2 ，¥3 ，¥4 。
 * 可以用 ¥4 购买 1A 和 1B ，也可以用 ¥9 购买 2A ，2B 和 1C 。
 * 需要买 1A ，2B 和 1C ，所以付 ¥4 买 1A 和 1B（大礼包 1），以及 ¥3 购买 1B ， ¥4 购买 1C 。
 * 不可以购买超出待购清单的物品，尽管购买大礼包 2 更加便宜。
 * @Version 1.0
 */
public class ShoppingOffers {
    int ans;
    int[] price;
    List<List<Integer>> special;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price.stream().mapToInt(i -> i).toArray();
        this.special = special;
        this.ans = 0;
        //初始解就是不购买任何礼包的花费
        for (int i = 0; i < price.size(); i++) {
            this.ans += this.price[i] * needs.get(i);
        }
        dfs(0, 0, needs.stream().mapToInt(i -> i).toArray());
        return ans;
    }

    //idx为当前礼包编号，cost为购买礼包的花费，needs[i]为需要购买第i件物品的数量
    private void dfs(int idx, int cost, int[] needs) {
        boolean nds = needsSatisfied(needs);//是否刚好满足需求
        //未满足需求且还有可选礼包，向后搜索
        if (idx < special.size() && !nds && cost<ans) {
            int[] iThGift = special.get(idx).stream().mapToInt(v -> v).toArray();//获取第i个礼包
            int iThGiftPrice = iThGift[iThGift.length - 1];//第idx个礼包的价格
            //买i个第idx个礼包后向后搜索
            for (int i = 0; needsCheck(iThGift, needs, i); i++) {
                add(needs, iThGift, -i);
                dfs(idx + 1, cost + i * iThGiftPrice, needs);
                add(needs, iThGift, i);//还原needs数组
            }
        } else if (nds && cost<ans) {//刚好满足需求，不再向后搜索
            ans = Math.min(ans, cost);
        } else {//不满足需求且已经遍历完了所有礼包
            //原价购买剩下的所有物品
            int total = cost;//总花费
            for (int i = 0; i < needs.length && total < ans; i++) {
                total += needs[i] * price[i];
            }
            ans = Math.min(ans, total);
        }
    }

    //检查买N个礼包是否可行
    private boolean needsCheck(int[] gift, int[] needs, int N) {
        for (int i = 0; i < needs.length; i++) {
            if (N * gift[i] > needs[i]) return false;
        }
        return true;
    }

    //验证是否满足需求
    private boolean needsSatisfied(int[] needs) {
        for (int need : needs) {
            if (need != 0) return false;
        }
        return true;
    }

    //a、b均为数组，计算∑(i=0~n-1)a[i] += b[i]*times
    private void add(int[] a, int[] b, int times) {
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i] * times;
        }
    }
}