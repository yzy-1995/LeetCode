package com.yzy.simple;

/**
 * Description: leetcode1869
 *
 * @author yzy15
 * @date 2023/05/02 13:54
 **/
public class LongerContiguousSegmentsofOnesthanZeros {
    public static void main(String[] args) {

    }


    public boolean checkZeroOnes(String s) {
        int maxLenOne = 0, maxLenZero = 0, lenOne = 0, lenZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                lenOne++;
                lenZero = 0;
            } else {
                lenZero++;
                lenOne = 0;
            }
            maxLenOne = Math.max(maxLenOne, lenOne);
            maxLenZero = Math.max(maxLenZero, lenZero);
        }
        return maxLenOne > maxLenZero;
    }
}
