package com.mayikt.thread.days08;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 余胜军
 * @ClassName Test008
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test008 {
    public static void main(String[] args) {
        Object objectLock = new Object();
        // hashCode 方法是一个懒加载
//        System.out.println(Integer.toHexString(objectLock.hashCode()));
        System.out.println(">>从对象头中获取到无锁的信息内容<<");
        System.out.println(ClassLayout.parseInstance(objectLock).toPrintable());
    }
}
