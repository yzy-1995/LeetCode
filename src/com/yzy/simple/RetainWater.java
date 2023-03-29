package com.yzy.simple;

/**
 * ClassName: RetainWater
 * Description:
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 *
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 *
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 *
 * 示例 1：
 *
 * 输入：bucket = [1,3], vat = [6,8]
 *
 * 输出：4
 *
 * 解释： 第 1 次操作升级 bucket[0]； 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * @author Administrator
 * @date 2023-3-27 15:42
 */
public class RetainWater {

    public static void main(String[] args) {
    int[] bucket={1,3};
    int[] vat={6,8};
        RetainWater retainWater = new RetainWater();
        System.out.println(retainWater.storeWater(bucket, vat));
    }
    public int storeWater(int[] bucket, int[] vat) {
        int maxK =  0 ;
        for (int v :vat) {
            maxK=Math.max(maxK,v);
        }
        if (maxK==0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= maxK ; i++) {
            if (i >= result){
                break;
            }
            int cur=i;
            for (int j = 0; j < vat.length; j++) {
                cur += Math.max(vat[j] / i  + (vat[j] % i == 0 ? 0 : 1) - bucket[j], 0);
            }
            result= Math.min(result,cur);
        }

        return result;
    }
}
