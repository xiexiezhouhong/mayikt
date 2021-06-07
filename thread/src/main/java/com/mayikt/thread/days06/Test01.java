package com.mayikt.thread.days06;

import java.util.Hashtable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    private static MayiktLock mayiktLock = new MayiktLock();

//    private static Lock mayiktLock = new ReentrantLock();
    private static Object lockObject=new Object();

    public static void main(String[] args) throws Exception {
        /**
         * 锁：
         * 获取锁---
         * 释放锁---
         * synchronized 属于具有可重入性
         */
//        a();
        synchronized (lockObject) {
            // 获取锁
            System.out.println("a");
            // 释放锁
        }
        synchronized (lockObject) {
            // 获取锁
            System.out.println("b");
            // 释放锁
        }

    }

    //
//    public static synchronized void a() {
//        System.out.println("a");
//        b();
//    }
//
//    public static synchronized void b() {
//        System.out.println("b");
//        c();
//    }
//
//    public static synchronized void c() {
//        System.out.println("c");
//    }
    public static void a() {
        // 当前主线程 cas 锁的状态改成为1
        mayiktLock.lock();
        System.out.println("a");
        b();
        mayiktLock.unLock();
    }

    //
    public static void b() {
        mayiktLock.lock();
        System.out.println("b");
        c();
        mayiktLock.unLock();
    }

    //
    public static synchronized void c() {
        mayiktLock.lock();
        System.out.println("c");
        mayiktLock.unLock();
    }

    //    public static void a() {
//        mayiktLock.lock();
//        System.out.println("a");
//        b();
//        mayiktLock.unlock();
//    }
//
//    //
//    public static void b() {
//        mayiktLock.lock();
//        System.out.println("b");
//        c();
//        mayiktLock.unlock();
//    }
//
//    //
//    public static synchronized void c() {
//        mayiktLock.lock();
//        System.out.println("c");
//        mayiktLock.unlock();
//    }

}
