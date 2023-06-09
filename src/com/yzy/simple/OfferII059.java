package com.yzy.simple;

/**
 * ClassName: OfferII059
 * Description:
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * @author Administrator
 * @date 2023-5-19 15:34
 */
public class OfferII059 {
    private int[] heap;
    private int last;
    private int limit;

    public OfferII059(int k, int[] nums) {
        limit = k;
        initHeap(nums);
    }

    public int add(int val) {
        if(last < limit) {
            siftUp(val);
        } else if(heap[0] < val) {
            heap[0] = val;
            siftDown();
        }

        return heap[0];
    }

    private void initHeap(int[] nums) {
        heap = new int[limit];
        for(int i = 0;i < nums.length;i ++) {
            add(nums[i]);
        }
    }

    private int getParent(int idx) {
        if(idx <= 0) {
            return -1;
        }
        return (idx-1) / 2;
    }

    private void siftDown() {
        int idx = 0;
        while(idx < last) {
            int lc = idx*2+1, rc = (idx+1)*2, child = last;
            if(rc < last)
                child = heap[lc] > heap[rc] ? rc : lc;
            else if(lc < last)
                child = lc;

            if (child != last && heap[child] < heap[idx]) {
                swap(child, idx);
                idx = child;
            } else {
                break;
            }
        }
    }

    private void siftUp(int target) {
        heap[last] = target;
        int idx = last, parent;
        last ++;
        while((parent = getParent(idx)) != -1 && heap[idx] < heap[parent]) {
            swap(idx, parent);
            idx = parent;
        }
    }

    private void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}
