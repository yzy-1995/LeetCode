package com.yzy.simple;

/**
 * ClassName: CalculateDelayedArrivalTime
 * Description:
 *
 * @author Administrator
 * @date 2023-5-12 10:21
 */
public class CalculateDelayedArrivalTime {
    public static void main(String[] args) {

    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
