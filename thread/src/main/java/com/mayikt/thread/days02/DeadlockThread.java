package com.mayikt.thread.days02;

public  class DeadlockThread implements Runnable {
    private int count = 1;
    private String lock = "lock";

    @Override
    public void run() {
        while (true) {
            count++;
            // 1%2= 2%2= 3%2= 4%2
            if (count % 2 == 0) {
                synchronized (lock) {
                    a();
                }
            } else {
                synchronized (this) {
                    b();
                }
            }
        }
    }

    public synchronized void a() {
        System.out.println(Thread.currentThread().getName() + ",a方法...");
    }

    public void b() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ",b方法...");
        }
    }

    public static void main(String[] args) {
        DeadlockThread deadlockThread = new DeadlockThread();
        Thread thread1 = new Thread(deadlockThread);
        Thread thread2 = new Thread(deadlockThread);
        thread1.start();
        thread2.start();
    }
}