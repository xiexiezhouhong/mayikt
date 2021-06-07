package com.mayikt.thread.days08;

import java.util.Hashtable;

/**
 * @author 余胜军
 * @ClassName Test06
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test06 {
    private static int count;

    public static void main(String[] args) {
        /**
         * 获取锁-- 正常执行
         * 释放锁---
         * 获取锁失败---当前线程直接阻塞等待
         */
        cal();
        a();
        b();
        /**
         * 优化变成偏向锁
         */
        Hashtable<String, String> hashtable = new Hashtable<>();
        for (int i=0;i<10000;i++){
            //synchronized 获取锁 释放锁
            hashtable.put("","");
        }
    }

    /**
     * t1 线程 获取到锁 1毫秒就释放锁
     * t1 线程获取到锁之后 60s 才会释放锁
     */
    public static synchronized void cal() {
        count++;
    }
    public static synchronized void a() {
        count++;
    }
    public static synchronized void b() {
        count++;
    }
}
