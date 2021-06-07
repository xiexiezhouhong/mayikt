package com.mayikt.thread.days01;

/**
 * @author 余胜军
 * @ClassName Thread02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "<我是子线程>");
    }

    public static void main(String[] args) {
//        // 启动线程
//        new Thread(new ThreadRunnable()).start();
        // 2.使用匿名内部类的形式创建线程
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "<我是子线程>"), "蚂蚁课堂余胜军线程").start();

    }
}
