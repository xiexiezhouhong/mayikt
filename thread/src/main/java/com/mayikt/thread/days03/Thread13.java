package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread13
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread13 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println(Thread.currentThread().getName() + "," + count++);
            }
        }, "t1线程:");
        Thread t2 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println(Thread.currentThread().getName() + "," + count++);
            }
        }, "t2线程:");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
