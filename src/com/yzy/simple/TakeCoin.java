package com.yzy.simple;

/**
 * ClassName: TakeCoin
 * Description:
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
 * 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * @author Administrator
 * @date 2023-3-27 10:39
 */
public class TakeCoin {
    public static void main(String[] args) {
        int [] a ={2,3,10};
        System.out.println(minCount(a));
    }

    public static int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int temp = 0;
            if (coins[i]%2==0){
                temp = coins[i]/2;
            }else if(coins[i]%2==1){
                temp =(coins[i]+1)/2;
            }
            count +=temp;
        }
        return count;
    }
}
