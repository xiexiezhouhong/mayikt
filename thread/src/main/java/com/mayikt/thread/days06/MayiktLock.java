package com.mayikt.thread.days06;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

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
     * 那个线程获取该锁
     */
    private Thread ownerLockThread;
    /**
     * 当前线程获取到锁 锁的重入次数
     */
    private int recursions;
    /**
     * 没有获取到锁的线程
     */
    private static LinkedBlockingDeque<Thread> notLockThreads = new LinkedBlockingDeque<Thread>();

    /**
     * recursions+1  获取锁成功 当前线程重入+1
     */
    public void lock() {
        if(recursions==0){
            return;
        }
        // 如果当前线程已经获取到锁的话，则不需要重复获取锁 直接复用
        if (ownerLockThread == Thread.currentThread()) {
            // 锁的重入次数+1
            recursions++;
            return;
        }
        /**
         * 两个线程同时执行 cas 操作 将锁的状态从0改成===11
         * 最终只有一个线程修改成功 自旋
         */
        /**
         * 每个线程 获取锁重试次数
         * ------不是重入 而是 重试
         *
         */
        int spinCount = 0;
        for (; ; ) {
            if (spinCount >= 3) {
                // 让我们当前线程变为阻塞状态
                notLockThreads.offer(Thread.currentThread());
                // 重量锁
                LockSupport.park();
                // 需要我们重试次数归0
                spinCount = 0;
            }
            // 优化代码 当前线程如果已经获取到锁 则直接复用
            if (lockState.compareAndSet(0, 1)) {
                // 当前线程获取锁成功
                ownerLockThread = Thread.currentThread();
                // 锁的重入次数+1 recursions==1
                recursions++;
                return;
            }
            spinCount++;

        }

    }

    public void unLock() {
        // 释放锁 需要通过 cas 将 11==变成0
        recursions--;
        if (recursions == 0) {
            for (; ; ) {
                if (lockState.compareAndSet(1, 0)) {
                    //唤醒所有没有获取到锁的线程 从新开始竞争锁的资源
                    notifyNotLockThreads();
                    return;
                }
            }

        }


    }

    /**
     * 唤醒没有获取到锁的线程
     */
    public void notifyNotLockThreads() {
        /**
         * 唤醒所有没有获取到锁的线程 从新开始竞争锁的资源
         * 非公平锁的实现
         */
//        notLockThreads.forEach((t) -> {
//            LockSupport.unpark(t);
//            notLockThreads.remove(t);
//        });
//        // 每次获取链表中第一个----
//        Thread  notLockThread = notLockThreads.poll();
//        if(notLockThread!=null){
//            LockSupport.unpark(notLockThread);
//        }
        /**
         * 取出当前队列中第一个 取出成功同时删除
         */



    }

    public static void main(String[] args) throws InterruptedException {
        MayiktLock mayiktLock = new MayiktLock();
        mayiktLock.lock();
        // 主线程已经获取锁 成功   在我们的C++Monitor 修改_owner=主线程
        // 如果同一个线程重复的调用lock方法C++Monitor+ _recursions ++1
        mayiktLock.lock();
        cal();

    }

//    public void cal() {
//        /**
//         * 如果当前只有一个线程获取锁的情况下 使用偏向锁
//         * 轻量锁（重试） 线程代码中 持有锁的时间非常短 重试
//         * 重量级 ----- 线程代码中 持有锁的时间非常长
//         */
////        synchronized (MayiktLock.class) {
////            // 获取锁
////            // 获取锁成功 同步代码执行时间 5毫秒
//////            Thread.sleep(60000);
////            // 释放锁
////        }
//
//
//    }

    public static void cal() throws InterruptedException {
        MayiktLock mayiktLock = new MayiktLock();
        // 主线程先调用lock方法
        mayiktLock.lock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 轻量锁 CAS 重试
                    mayiktLock.lock();
                } catch (Exception e) {

                } finally {
                    mayiktLock.unLock();
                }
            }
        });
        t1.start();
        Thread.sleep(5000);
        mayiktLock.unLock();
        // 主线程调用lock方法就会重试获取锁3

    }


}


