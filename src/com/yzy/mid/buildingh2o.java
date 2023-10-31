package com.yzy.mid;

import java.util.concurrent.Semaphore;

/**
 * @Author 杨泽宇
 * @PackageName LeetCode
 * @Package com.yzy.mid
 * @Date 2023/11/01 00:03
 * @Description
 * @Version 1.0
 */
public class buildingh2o {
    public buildingh2o() {

    }
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(0);
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}