package com.mayikt.thread.days03;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 余胜军
 * @ClassName Thread09
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread09 extends Thread {
    private volatile boolean isStart = true;

    @Override
    public void run() {
        while (isStart) {
//            if (this.isInterrupted()) {
//                break;
//            }

        }
    }

    public static void main(String[] args) {
        Thread09 thread09 = new Thread09();
        thread09.start();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        System.out.println("<<中断子线程>,>");
        // 中断 阻塞或者正在运行的线程
        thread09.isStart = false;
        new ConcurrentHashMap<>();


    }
}
