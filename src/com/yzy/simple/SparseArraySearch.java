package com.yzy.simple;

/**
 * Description: le
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * <p>
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 * <p>
 * words的长度在[1, 1000000]之间
 *
 * @author yzy15
 * @date 2023/05/20 15:56
 **/
public class SparseArraySearch {

    public int findString(String[] words, String s) {
        //二分
        int len = words.length;
        int i = 0;
        int j = len - 1;
        int mid = (j - i) / 2 + i;
        while (i <= j) {
            //index的作用{当words[mid]为“”空字符是，我们记录mid的位置，那么我们就可以大胆的对mid进行移位操作了，无论是左移还是右移，目的就是为了找到一个非空字符串跟s来比较，大了往左，小了往右}
            //还是一道简单的二分查找问题，就是多了一个干扰项“”，和字符串的比较大小words[mid].compareTo(s)>0
            //index的作用就体现了，当你一开始就对mid移动，那么我去有区间的路上要把我最开始走过的连续空字符的道路给去掉
            int index = mid;
            while (mid > i && words[mid].equals("")) mid--;
            if (words[mid].equals(s)) return mid;
            else if (words[mid].compareTo(s) > 0) {
                j = mid - 1;
            } else {
                i = index + 1;
            }
            mid = (j - i) / 2 + i;
        }
        return -1;
    }
}
