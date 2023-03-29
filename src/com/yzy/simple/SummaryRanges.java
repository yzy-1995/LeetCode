package com.yzy.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SummaryRanges
 * Description:
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * @author Administrator
 * @date 2023-3-29 9:45
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }

    /**
     * 可以使用贪心算法来解决这个问题。
     *
     * 我们可以从左到右遍历整个数组，使用两个指针 start 和 end 来记录当前覆盖区间的范围。
     * 初始时，start 和 end 都指向数组的第一个元素。然后，我们每次尽可能地扩展 end 指针，
     * 使得覆盖范围内的元素数量最多，并且这个范围内的元素与 nums[start:end+1] 相同。
     * 扩展 end 指针的过程可以通过不断比较 nums[end] 和 nums[start:end+1] 中的元素来实现。
     * 当 end 指针无法再扩展时，我们就找到了一个覆盖范围，将其加入答案列表中，
     * 并将 start 指针移动到 end+1 的位置，开始寻找下一个覆盖范围。
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return list;
        }
        int n = nums.length;
        int start =0,end=0;
        while (end < n){
            while(end<n-1&&nums[end+1]==nums[end]+1){
                end++;
            }
            if (nums[start]==nums[end]){
                list.add(Integer.toString(nums[start]));
            }else{
                list.add((nums[start])+"->"+(nums[end]));
            }
            start = end +1;
            end = start;
        }

        return list;
    }
}
