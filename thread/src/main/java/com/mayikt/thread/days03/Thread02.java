package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread02 {
    public static void main(String[] args) {
        // t1 run方法执行完毕 唤醒---t2 正在等待
        Thread t1 = new Thread(() ->
                System.out.println(Thread.currentThread().getName() + ",线程执行")
                , "t1");
        // t2需要等待t1执行完毕
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // t1.wait(); t2调用 t1(this锁).wait() 主动释放this锁 同时t2线程变为阻塞状态。
                    t1.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",线程执行");
            }
        }, "t2");
        // t3需要等待t2执行
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",线程执行");
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
