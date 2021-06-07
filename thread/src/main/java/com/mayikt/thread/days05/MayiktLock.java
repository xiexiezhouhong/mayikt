package com.mayikt.thread.days05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 余胜军
 * @ClassName MayiktLock
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MayiktLock {
    /**
     * lockState===0没有任何线程获取到该锁
     * lockState===1已经有线程获取到该锁
     */
    private AtomicInteger lockState = new AtomicInteger(0);

    /**
     *
     */
    public void lock() {
        /**
         * 两个线程同时执行 cas 操作 将锁的状态从0改成===11
         * 最终只有一个线程修改成功 自旋
         */
        for (; ; ) {
            if (lockState.compareAndSet(0, 1)) {
                return;
            }
            // 获取失败 重试获取锁
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }

    }

    public void unLock() {
        // 释放锁 需要通过 cas 将 11==变成0
        for (; ; ) {
            if (lockState.compareAndSet(1, 0)) {
                return;
            }
            // 获取失败 重试获取锁
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        MayiktLock mayiktLock = new MayiktLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mayiktLock.lock();
            }
        });
        t1.start();
        // 主线程让我们的子线程先执行
        t1.join();
        mayiktLock.lock();
        System.out.println("111111");
//        mayiktLock.unLock();
//        System.out.println("111111");
    }
}
