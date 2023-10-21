package com.yzy.mid;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/10/20 08:20
 * @Description
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 *
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 *
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * @Version 1.0
 */
public class intervallistintersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }

        int index1 = 0, index2 = 0, index3 = 0;
        int[][] tmp = new int[firstList.length + secondList.length][2];
        while(index1 < firstList.length && index2 < secondList.length){
            //下面两种是没有交集的情况，跳过
            if(firstList[index1][1] < secondList[index2][0]){
                index1++;
                continue;
            }
            if(secondList[index2][1] < firstList[index1][0]){
                index2++;
                continue;
            }

            if(firstList[index1][0] <= secondList[index2][0]){
                if(firstList[index1][1] <= secondList[index2][1]){
                    tmp[index3++] = new int[]{secondList[index2][0], firstList[index1++][1]};
                }else{
                    tmp[index3++] = secondList[index2++];
                }
            }else{
                if(firstList[index1][1] <= secondList[index2][1]){
                    tmp[index3++] = firstList[index1++];
                }else{
                    tmp[index3++] = new int[]{firstList[index1][0], secondList[index2++][1]};
                }
            }
        }

        int[][] ret = new int[index3][2];
        for(int i = 0; i < index3; i++){
            ret[i] = tmp[i];
        }
        return ret;
    }
}