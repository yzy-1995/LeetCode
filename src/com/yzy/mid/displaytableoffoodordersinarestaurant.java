package com.yzy.mid;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/12/13 00:06
 * @Description
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 *
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 *
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 * @Version 1.0
 */
public class displaytableoffoodordersinarestaurant {
    private List<List<String>> resultList = new ArrayList<>();

    private List<Table> tables = new ArrayList<>();

    private List<String> foodItemList = new ArrayList<>();

    public List<List<String>> displayTable(List<List<String>> orders) {
        orders.forEach(order -> {
            int number = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            if (foodItemList.stream().noneMatch(item -> item.equals(foodItem))) {
                foodItemList.add(foodItem);
            }

            if (tables.stream().anyMatch(table -> table.number == number)) {
                serveTable(number, foodItem);
            } else {
                initTable(number, foodItem);
            }
        });

        Collections.sort(foodItemList);

        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodItemList);
        resultList.add(header);

        tables.stream().sorted(Comparator.comparing(table -> table.number)).forEach(table -> {
            List<String> list = new ArrayList<>();
            list.add("" + table.number);

            list.addAll(foodItemList.stream()
                    .map(item -> "" + table.map.getOrDefault(item, 0)).collect(Collectors.toList()));
            resultList.add(list);
        });

        return resultList;
    }

    private void initTable(int number, String foodItem) {
        Table table = new Table(number);
        table.map.put(foodItem, 1);
        tables.add(table);
    }

    private void serveTable(int number, String foodItem) {
        tables.stream().filter(table -> table.number == number).limit(1).forEach(table -> {
            if (!table.map.containsKey(foodItem)) {
                table.map.put(foodItem, 1);
            } else {
                int size = table.map.get(foodItem);
                table.map.put(foodItem, ++size);
            }
        });
    }

    static class Table {
        int number;
        Map<String, Integer> map = new HashMap<>();

        public Table(int number) {
            this.number = number;
        }
    }
}