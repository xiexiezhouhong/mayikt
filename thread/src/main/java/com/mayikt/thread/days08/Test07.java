package com.mayikt.thread.days08;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 余胜军
 * @ClassName Test07
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test07 {
    public static void main(String[] args) {
        MayiktLock mayiktLock = new MayiktLock();
        System.out.println(ClassLayout.parseInstance(mayiktLock).toPrintable());
    }

    static class MayiktLock {

    }
}
