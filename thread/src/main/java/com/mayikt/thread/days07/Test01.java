package com.mayikt.thread.days07;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    private static int count;
    private static Object objectLock = new Object();
    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    public static void main(String[] args) {
        count();
        /**
         * Monitorenter：获取锁-----lock.lock();
         * i++
         * int j =1/0
         * Monitorexit：释放锁 ---- lock.unlock();
         */
        try {
            // 获取锁
            lock.lock();
            i++;
            int j = 1 / 0;
            lock.unlock();
        } catch (Exception e) {
            lock.unlock();
        }


    }

    /**
     * c++
     */
//    public static void count() {
//        /**
//         * monitor c++对象
//         */
//        synchronized (objectLock) {
//            // 临界区
//            count++;
//        }
//    }
    public static synchronized void count() {
  // jni

    }


}
