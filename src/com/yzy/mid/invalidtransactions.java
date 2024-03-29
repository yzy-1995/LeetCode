package com.yzy.mid;

import java.util.*;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/06 00:01
 * @Description
 * 如果出现下述两种情况，交易 可能无效：
 *
 * 交易金额超过 $1000
 * 或者，它和 另一个城市 中 同名 的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 给定字符串数组交易清单 transaction 。每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 返回 transactions，返回可能无效的交易列表。你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
 * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 示例 2：
 *
 * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * 输出：["alice,50,1200,mtv"]
 * 示例 3：
 *
 * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * 输出：["bob,50,1200,mtv"]
 * @Version 1.0
 */
public class invalidtransactions {
    public List<String> invalidTransactions(String[] transactions) {
        //存放要删除的交易的索引
        Set<Integer> delSet = new HashSet<Integer>();
        //同名可能有多条记录，这里使用 Map<String, List<Pair>>
        Map<String, List<Pair>> dataMap = new HashMap<String, List<Pair>>();

        int len = transactions.length;
        for(int i = 0; i < len; i++){
            Pair pair = new Pair(i, transactions[i]);
            //交易金额超过 ¥1000
            if(pair.amount > 1000){
                delSet.add(pair.idx);
            }
            //它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
            if(!dataMap.containsKey(pair.name)){
                dataMap.put(pair.name, new ArrayList<Pair>());
            }else{
                List<Pair> list = dataMap.get(pair.name);
                for(Pair p : list){
                    //如果它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
                    if(!p.city.equals(pair.city) && Math.abs(p.time - pair.time) <= 60){
                        delSet.add(p.idx);
                        delSet.add(pair.idx);
                    }
                }
            }
            dataMap.get(pair.name).add(pair);
        }

        //返回结果
        List<String> ansList = new ArrayList<String>();
        for(Integer idx : delSet){
            ansList.add(transactions[idx]);
        }

        return ansList;
    }

    class Pair{
        int idx;
        String name;
        int time;
        int amount;
        String city;
        public Pair(int idx, String str){
            String[] arr = str.split(",");
            this.idx = idx;
            this.name = arr[0];
            this.time = Integer.parseInt(arr[1]);
            this.amount = Integer.parseInt(arr[2]);
            this.city = arr[3];
        }
    }
}