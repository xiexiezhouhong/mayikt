package com.mayikt.thread.days08;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 余胜军
 * @ClassName Test04
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test04 {
    private static Object objectLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        //-XX:BiasedLockingStartupDelay=0 强制开启
//        System.out.println(">>----------------无锁状态-------------------<<");
        System.out.println(ClassLayout.parseInstance(objectLock).toPrintable());
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectLock) {
                    try {
                        System.out.println("子线程获取到 对象头信息内容");
                        System.out.println(ClassLayout.parseInstance(objectLock).toPrintable());
                        Thread.sleep(5000);
                        System.out.println("..子线程..");
                    } catch (Exception e) {

                    }
                }
            }
        }, "子线程1").start();
        Thread.sleep(1000);
        sync();
    }

    public static void sync() throws InterruptedException {
        System.out.println(" 主线程获取锁 重量级别锁");
        synchronized (objectLock) {
            System.out.println(ClassLayout.parseInstance(objectLock).toPrintable());
        }
        /**
         * synchronized指定一个 任意 java对象 objectLock 存放 锁的信息
         */
    }

}
