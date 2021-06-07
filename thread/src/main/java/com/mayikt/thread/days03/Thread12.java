package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread12
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread12 extends Thread {
    public Thread12(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i == 30) {
                System.out.println(Thread.currentThread().getName() + ",释放cpu执行权");
                this.yield();
            }
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }

    public static void main(String[] args) {
        new Thread12("mayikt01").start();
        new Thread12("mayikt02").start();
    }
}
