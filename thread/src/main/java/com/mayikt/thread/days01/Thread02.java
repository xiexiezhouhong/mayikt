package com.mayikt.thread.days01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 余胜军
 * @ClassName Thread02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(threadCallable);
        new Thread(integerFutureTask).start();
        // 我的主线程需要等待我们子线程给我的返回结果
        Integer result1 = integerFutureTask.get();
        System.out.println(Thread.currentThread().getName() + "," );
//        LockSupport.park();
//        LockSupport.unpark();
        // juc 并发中
//        Thread thread01 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是子线程开始");
//                LockSupport.park();
//                System.out.println("我是子线程结束");
//            }
//        });
//        thread01.start();
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//
//        }
//        LockSupport.unpark(thread01);

    }
}
