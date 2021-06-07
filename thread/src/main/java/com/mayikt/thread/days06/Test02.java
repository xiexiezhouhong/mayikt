package com.mayikt.thread.days06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 余胜军
 * @ClassName Test02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test02 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
//        new Thread(() -> {
//            while (true) {
//
//            }
//        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("...定时任务执行..");
//                    // 跑批---  蚂蚁课堂注册用户 100万

                }
            }
        }).start();
    }
}
