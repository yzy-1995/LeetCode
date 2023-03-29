package com.yzy.simple;

/**
 * ClassName: MoveZeroes
 * Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @author Administrator
 * @date 2023-3-28 9:18
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int [] zeroes = new int[]{0,0,0,1,2,3,4,0,1,5,7};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(zeroes);
    }
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
        for (Integer o :nums) {
            System.out.print(o+",");
        }
    }
}
