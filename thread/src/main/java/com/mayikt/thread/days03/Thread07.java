package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread07
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread07 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程运行在cpu之上
                while (true) {
                    try {
                        Thread.sleep(30);
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }
}
