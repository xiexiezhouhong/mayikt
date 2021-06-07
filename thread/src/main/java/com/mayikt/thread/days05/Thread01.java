package com.mayikt.thread.days05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 余胜军
 * @ClassName Thread01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread01 extends Thread {
    private static int sum = 0;
    /**
     * value=0
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        sum();
    }

    public void sum() {
        for (int i = 0; i < 10000; i++) {
//            sum++;
            // 对当前原子类 value++ cas实现 lock锁
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread01 t1 = new Thread01();
        Thread01 t2 = new Thread01();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicInteger.get());

    }
}
