package com.mayikt.thread.days03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 余胜军
 * @ClassName ThreadCount
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ThreadCount2 implements Runnable {
    private static int count = 100;
    private Lock lock = new ReentrantLock();

    /**
     * 如何保证线程一直在运行状态 死循环控制
     */
    @Override
    public void run() {
        while (true) {
            try {
                //运行状态----休眠状态--cpu的执行权让给其他的线程
                // 休眠----运行状态
                Thread.sleep(30);
            } catch (Exception e) {

            }
            cal();
        }
    }

    /**
     * 1.如果将synchronized 加载我们实例方法上 ，则使用this锁
     * 2.如果将synchronized 加载我们静态方法上 ，类名.class
     */
    public void cal() {
//        synchronized (ThreadCount2.class) {
        try {
               lock.lock();
            if (count > 1) {
                count--;
                System.out.println(Thread.currentThread().getName() + "," + count);

            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
//        }

    }

    /**
     * public  void cal() {
     * synchronized（this）{
     * if (count > 1) {
     * count--;
     * System.out.println(Thread.currentThread().getName() + "," + count);
     * <p>
     * }
     * }
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
//        ThreadCount threadCount1 = new ThreadCount();
//        ThreadCount threadCount2 = new ThreadCount();
//        new Thread(threadCount1).start();
//        new Thread(threadCount2).start();
        ThreadCount2 threadCount1 = new ThreadCount2();
        new Thread(threadCount1).start();
        new Thread(threadCount1).start();
    }
}
