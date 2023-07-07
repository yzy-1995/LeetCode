package com.yzy.mid;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/07/07 23:16
 * @Description 共有 k 位工人计划将 n 个箱子从旧仓库移动到新仓库。给你两个整数 n 和 k，以及一个二维整数数组 time ，数组的大小为 k x 4 ，其中 time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] 。
 * <p>
 * 一条河将两座仓库分隔，只能通过一座桥通行。旧仓库位于河的右岸，新仓库在河的左岸。开始时，所有 k 位工人都在桥的左侧等待。为了移动这些箱子，第 i 位工人（下标从 0 开始）可以：
 * <p>
 * 从左岸（新仓库）跨过桥到右岸（旧仓库），用时 leftToRighti 分钟。
 * 从旧仓库选择一个箱子，并返回到桥边，用时 pickOldi 分钟。不同工人可以同时搬起所选的箱子。
 * 从右岸（旧仓库）跨过桥到左岸（新仓库），用时 rightToLefti 分钟。
 * 将箱子放入新仓库，并返回到桥边，用时 putNewi 分钟。不同工人可以同时放下所选的箱子。
 * 如果满足下面任一条件，则认为工人 i 的 效率低于 工人 j ：
 * <p>
 * leftToRighti + rightToLefti > leftToRightj + rightToLeftj
 * leftToRighti + rightToLefti == leftToRightj + rightToLeftj 且 i > j
 * 工人通过桥时需要遵循以下规则：
 * <p>
 * 如果工人 x 到达桥边时，工人 y 正在过桥，那么工人 x 需要在桥边等待。
 * 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。如果同时有多个工人在右边等待，那么 效率最低 的工人会先过桥。
 * 如果没有正在过桥的工人，且桥右边也没有在等待的工人，同时旧仓库还剩下至少一个箱子需要搬运，此时在桥左边的工人可以过桥。如果同时有多个工人在左边等待，那么 效率最低 的工人会先过桥。
 * 所有 n 个盒子都需要放入新仓库，请你返回最后一个搬运箱子的工人 到达河左岸 的时间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 3, time = [[1,1,2,1],[1,1,3,1],[1,1,4,1]]
 * 输出：6
 * 解释：
 * 从 0 到 1 ：工人 2 从左岸过桥到达右岸。
 * 从 1 到 2 ：工人 2 从旧仓库搬起一个箱子。
 * 从 2 到 6 ：工人 2 从右岸过桥到达左岸。
 * 从 6 到 7 ：工人 2 将箱子放入新仓库。
 * 整个过程在 7 分钟后结束。因为问题关注的是最后一个工人到达左岸的时间，所以返回 6 。
 * 示例 2：
 * <p>
 * 输入：n = 3, k = 2, time = [[1,9,1,8],[10,10,10,10]]
 * 输出：50
 * 解释：
 * 从 0 到 10 ：工人 1 从左岸过桥到达右岸。
 * 从 10 到 20 ：工人 1 从旧仓库搬起一个箱子。
 * 从 10 到 11 ：工人 0 从左岸过桥到达右岸。
 * 从 11 到 20 ：工人 0 从旧仓库搬起一个箱子。
 * 从 20 到 30 ：工人 1 从右岸过桥到达左岸。
 * 从 30 到 40 ：工人 1 将箱子放入新仓库。
 * 从 30 到 31 ：工人 0 从右岸过桥到达左岸。
 * 从 31 到 39 ：工人 0 将箱子放入新仓库。
 * 从 39 到 40 ：工人 0 从左岸过桥到达右岸。
 * 从 40 到 49 ：工人 0 从旧仓库搬起一个箱子。
 * 从 49 到 50 ：工人 0 从右岸过桥到达左岸。
 * 从 50 到 58 ：工人 0 将箱子放入新仓库。
 * 整个过程在 58 分钟后结束。因为问题关注的是最后一个工人到达左岸的时间，所以返回 50 。
 * @Version 1.0
 */
public class Time2CrossABridge {
    // 2532 k个工人，n个箱子
    public int findCrossingTime(int n, int k, int[][] time) {
        // 创建等待队列
        ArrayList<TempClass> waitList = new ArrayList<>();
        // 初始化数据
        for (int i = 0; i < k; i++) {
            waitList.add(new TempClass(i, 0, 0, time[i][0], time[i][1], time[i][2], time[i][3]));
        }
        // 先排序，初次排序后，此顺序不会改变。
        // 只改变对象的状态，在哪个队列，何时才能进行下一次搬运动作
        waitList = (ArrayList<TempClass>) waitList.stream()
                .sorted((o1, o2) -> {
                    if (o1.rightToLeft + o1.leftToRight != o2.rightToLeft + o2.leftToRight) {
                        return (o2.leftToRight + o2.rightToLeft) - (o1.leftToRight + o1.rightToLeft);
                    }
                    return o2.index - o1.index;
                })
                .collect(Collectors.toList());
        int nowTime = 0;
        while (n != 0) {
            // 先从桥的右侧等待队列中选择人
            int actionIndex = selectLower(waitList, nowTime, 1);
            // 如果右侧等待队列中有人，则先让右侧的人走
            if (actionIndex != -1) {
                // 获得该工人对象
                TempClass actionR = waitList.get(actionIndex);
                // 将该工人的状态置为 在桥的左侧
                actionR.isHere = 0;
                // 该工人在此时刻开始过桥，并且放下货物，在validTime时刻再次到达左侧桥头
                actionR.validTime = nowTime + actionR.rightToLeft + actionR.putNew;
                // 将修改后的工人对象放回列表中
                waitList.set(actionIndex, actionR);
                // 将当前时间设定为该工人过桥之后
                nowTime += actionR.rightToLeft;
                continue;
            }
            // 右侧没有人，再从左侧等待队列中选择人
            actionIndex = selectLower(waitList, nowTime, 0);
            // 左侧还没有人，就将时间往后推进
            if (actionIndex == -1) {
                // 从左右两个队列中选择最近的能够工作的工人
                TempClass leftMinVaildTime = selectMinVaildTime(waitList, 0);
                TempClass rightMinVaildTime = selectMinVaildTime(waitList, 1);
                if (leftMinVaildTime == null) {
                    nowTime = rightMinVaildTime.validTime;
                    continue;
                }
                if (rightMinVaildTime == null) {
                    nowTime = leftMinVaildTime.validTime;
                    continue;
                }
                nowTime = Math.min(leftMinVaildTime.validTime, rightMinVaildTime.validTime);
                continue;
            }
            // 左侧有人可以过桥
            TempClass actionL = waitList.get(actionIndex);
            actionL.isHere = 1;
            actionL.validTime = nowTime + actionL.leftToRight + actionL.pickOld;
            waitList.set(actionIndex, actionL);
            nowTime += actionL.leftToRight;
            // 有一个货物被拿起
            n--;
        }
        // 所有右侧人员过桥
        while (true) {
            // 从右侧队列中选择能过桥的人
            int actionIndex = selectLower(waitList, nowTime, 1);
            if (actionIndex == -1) {
                // 如果没有就选择最近的能过桥的人，将时间推到那时候
                TempClass minVaild = selectMinVaildTime(waitList, 1);
                // 如果右侧的人都走完了，则退出循环
                if (minVaild == null) {
                    break;
                }
                nowTime = minVaild.validTime;
                continue;
            }
            TempClass acitonR = waitList.get(actionIndex);
            acitonR.isHere = 0;
            waitList.set(actionIndex, acitonR);
            nowTime += acitonR.rightToLeft;
        }
        return nowTime;
    }

    // 选择队列中最近的能进行下一次过桥的工人
    public TempClass selectMinVaildTime(ArrayList<TempClass> tempList, int isHere) {
        ArrayList<TempClass> temp = (ArrayList<TempClass>) tempList.stream()
                .filter(l -> l.isHere == isHere)// 过滤掉另一个队列
                .collect(Collectors.toList());
        if (temp.size() == 0) {
            return null;
        }
        if (temp.size() == 1) {
            return temp.get(0);
        }
        return temp.stream()
                .sorted((o1, o2) -> o1.validTime - o2.validTime)
                .collect(Collectors.toList()).get(0);
    }

    // 选择第一个能过桥的人，因为list按照效率从低到高排序，只要选择第一个能过桥的即可
    public int selectLower(ArrayList<TempClass> tempList, int nowTime, int isHere) {
        int index = 0;
        for (TempClass temp : tempList) {
            if (temp.isHere == isHere && temp.validTime <= nowTime) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

class TempClass {
    TempClass() {
    }

    TempClass(int index, int isHere, int validTime, int leftToRight, int pickOld, int rightToLeft, int putNew) {
        this.index = index;
        this.isHere = isHere;
        this.validTime = validTime;
        this.leftToRight = leftToRight;
        this.pickOld = pickOld;
        this.rightToLeft = rightToLeft;
        this.putNew = putNew;
    }

    // 工人的id
    int index;
    // 工人在左侧等待队列还是右侧等待队列
    // 0 在桥左侧等待 1 在桥右侧等待
    int isHere;
    // 工人什么时候能进行下一次的过桥。
    // 初始化为0，当工人被选中过桥后，此值更新为 当前时间+过桥时间+处理货物时间
    int validTime;
    int leftToRight;
    int pickOld;
    int rightToLeft;
    int putNew;
}