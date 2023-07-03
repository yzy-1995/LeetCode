package com.yzy.mid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/06/30 22:36
 * @Description
 * @Version 1.0
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index;
    private void add(List<NestedInteger> nestedIntegerList){
        for (NestedInteger nestedInteger :nestedIntegerList) {
            if (nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            }else {
                add(nestedIntegerList.getList());
            }
        }

    }
    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }



    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }


}