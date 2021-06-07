package com.mayikt.thread.days04;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 余胜军
 * @ClassName MayiktFutureTask
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MayiktFutureTask<V> implements Runnable {
    private MayiktCallable<V> mayiktCallable;
    private Object lock = new Object();
    private V result;
    private Thread cuThread;


    public MayiktFutureTask(MayiktCallable<V> mayiktCallable) {
        this.mayiktCallable = mayiktCallable;
    }

    @Override
    public void run() {
        // 线程需要执行代码
        result = mayiktCallable.call();
        // 如果子线程执行完毕 唤醒主线程 可以拿到返回结果
//        synchronized (lock) {
//            lock.notify();
//        }
        if (cuThread != null)
            // 唤醒 cuThread
            LockSupport.unpark(cuThread);
    }

    public V get() {
        // 获取子线程异步执行完毕之后的返回结果
        // 主线程阻塞
//        synchronized (lock) {
//            try {
//                lock.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        // 主线程阻塞
        cuThread = Thread.currentThread();
        LockSupport.park();
        return result;
    }
}
