package com.mayikt.thread.days04;

/**
 * @author 余胜军
 * @ClassName Thread2
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread02 extends Thread {
    private static int sum = 0;

    @Override
    public void run() {
//        sum();
        while (true){

        }
    }

    public void sum() {
        for (int i = 0; i < 10000; i++) {
            sum++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread02 t1 = new Thread02();
        Thread02 t2 = new Thread02();
        t1.start();
        t2.start();
        // 主线程先让 t1 t2 执行
        t1.join();
        t2.join();
        System.out.println(sum);
    }
}
