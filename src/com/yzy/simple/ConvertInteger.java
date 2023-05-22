package com.yzy.simple;

/**
 * Description: le
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * @author yzy15
 * @date 2023/05/20 15:20
 **/
public class ConvertInteger {
    public int convertInteger(int A, int B) {
        int x = A ^ B, cnt = 0;
        while (x != 0) {
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }
}
