package com.yzy.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/04 21:54
 * @Description
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 *
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 *
 *
 * 示例：
 *
 * 输入：["SnapshotArray","set","snap","set","get"]
 *      [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 * @Version 1.0
 */
public class snapshotarray {
    List<List<int[]>> snapshots;
    int version;

    public snapshotarray(int length) {
        version = 0;
        snapshots = new ArrayList<>();
        for (int i = 0; i < length; i++)
            snapshots.add(new ArrayList<>());
    }

    public void set(int index, int val) {
        List<int[]> snapshot = snapshots.get(index);
        if (!snapshot.isEmpty() && snapshot.get(snapshot.size() - 1)[0] == version)
            snapshot.get(snapshot.size() - 1)[1] = val;
        else
            snapshots.get(index).add(new int[]{version, val});
    }

    // 此处超时，需要优化
    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        // 查找第一个小于等于snap_id的元素
        List<int[]> snapshot = snapshots.get(index);
        int left = 0;
        int right = snapshot.size() - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (snapshot.get(middle)[0] <= snap_id)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left == 0 ? 0 : snapshot.get(left - 1)[1];
    }
}