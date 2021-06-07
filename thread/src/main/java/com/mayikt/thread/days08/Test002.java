package com.mayikt.thread.days08;

import com.mayikt.thread.days06.MayiktLock;
import org.openjdk.jol.info.ClassLayout;

public class Test002 extends Thread {
    private static Object mayiktLock = new Object();

    @Override
    public void run() {

    }

    public void create() {

    }

    public static void main(String[] args) {
        // -XX:BiasedLockingStartupDelay=0  开启偏向锁
        //-XX:-UseCompressedOops --关闭对象头压缩
        Object o = new Object();
        System.out.println(">>----------------无锁状态-------------------<<");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}