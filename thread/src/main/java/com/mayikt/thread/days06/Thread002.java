package com.mayikt.thread.days06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread002 implements Runnable {
    private static int count = 0;
    private static Lock lock = new ReentrantLock(false);

    @Override
    public void run() {

        while (count < 200) {
//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//
//            }
            lock.lock();
//            System.out.println(Thread.currentThread().getName() + ",count:" + count);
//            count++;
            createCount();
            lock.unlock();
        }
    }

    public void createCount() {
        System.out.println(Thread.currentThread().getName() + ",count:" + count);
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Thread002()).start();
        }
    }
}