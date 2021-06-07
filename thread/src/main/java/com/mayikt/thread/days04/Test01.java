package com.mayikt.thread.days04;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",1");
                // 阻塞当前线程
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + "2");
            }
        });
        t1.start();
        // 主线程3s之后在唤醒 子线程继续向下执行
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        LockSupport.unpark(t1);
    }
}
