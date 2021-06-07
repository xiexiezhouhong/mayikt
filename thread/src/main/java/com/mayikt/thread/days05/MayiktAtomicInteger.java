package com.mayikt.thread.days05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 余胜军
 * @ClassName MayiktAtomicInteger
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MayiktAtomicInteger {
    /**
     * 递增 线程安全性问题
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public  int incrementAndGet() {
        return getAndAddInt() + 1;
    }

    public int getAndAddInt() {
        // 对当前 全局变量值 v+++
        // 获取旧的预期值
        //获取V全局变量值 cpu飙高的问题
        for (; ; ) {
            int expect = atomicInteger.get();
            if (atomicInteger.compareAndSet(120, expect + 1)) {
                return expect;
            }
            try {
                Thread.sleep(30);
            } catch (Exception e) {

            }

        }

    }

    public static void main(String[] args) {
        MayiktAtomicInteger mayiktAtomicInteger = new MayiktAtomicInteger();
        mayiktAtomicInteger.incrementAndGet();
        /**
         * expect===旧的预期值
         * update 改的新值
         *expect===旧的预期值===V
         */
//        for (; ; ) {
//            if (atomicInteger.compareAndSet(1, 1)) {
//                return;
//            }
//        }
//

        /**
         * 旧的预期值：expect
         * 新的值=update
         * V=0
         * cas 算法
         * 旧的预期值：===V  V===N
         */
//        boolean result = atomicInteger.compareAndSet(0, 2);
//        System.out.println(result + "," + atomicInteger.get());
//        MayiktAtomicInteger mayiktAtomicInteger = new MayiktAtomicInteger();
//        mayiktAtomicInteger.incrementAndGet();
//        System.out.println(atomicInteger.get());
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
    }

}
