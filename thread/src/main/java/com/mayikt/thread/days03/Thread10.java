package com.mayikt.thread.days03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 余胜军
 * @ClassName Thread10
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread10 {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        /**
         * Lock 获取锁 和释放锁 需要开发人员自己定义
         */
        Thread10 thread10 = new Thread10();
        thread10.print1();
        try {
            Thread.sleep(500);
            System.out.println("开始执行线程2抢锁");
        } catch (Exception e) {

        }
        thread10.print2();
    }

    public void print1() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 获取锁
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "获取锁成功");
                } catch (Exception e) {

                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        }, "t1").start();
    }

    public void print2() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "，1");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "，2");
            }
        }, "t2").start();
    }
}
