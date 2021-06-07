package com.mayikt.thread.days08;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 余胜军
 * @ClassName Test03
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test03 {
    public static void main(String[] args) {
        /**
         * 没有关闭指针压缩
         * 开启指针压缩
         * 正常 new 对象 没有任何属性 12字节      int j = 4;=4
         * 12+4=16
         */
        MayiktLockObject mayiktLockObject = new MayiktLockObject();
        System.out.println(ClassLayout.parseInstance(mayiktLockObject).toPrintable());
    }

    static class MayiktLockObject {
        int j = 4;
        long i = 1;
        //24  boolean 类型占用1个字节   25+7=/32==/8
        boolean m = false;

    }
}
