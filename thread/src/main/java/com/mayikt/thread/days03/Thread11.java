package com.mayikt.thread.days03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 余胜军
 * @ClassName Thread11
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread11 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread11 thread11 = new Thread11();
        thread11.cal();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        thread11.signal();


    }

    public void signal() {
        try {
            lock.lock();
            //
//            this.notify();
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void cal() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 主动释放锁 同时当前线程变为阻塞状态
                try {
                    lock.lock();
                    System.out.println("1");
                    condition.await();
                    System.out.println("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
