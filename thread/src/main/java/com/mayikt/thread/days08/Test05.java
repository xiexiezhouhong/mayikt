package com.mayikt.thread.days08;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 余胜军
 * @ClassName Test05
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test05 {
    private static Object objectLock = new Object();

    public static void main(String[] args) {
        //将10进制转化成16进制 161cd475
        objectLock.hashCode();
        System.out.println(Integer.toHexString(objectLock.hashCode()));
        System.out.println(ClassLayout.parseInstance(objectLock).toPrintable());
    }
}
