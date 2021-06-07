package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread08
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread08 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }, "我是子线程");
        thread.setDaemon(true);
        System.out.println("我的主线程代码执行完毕..");
    }
}
