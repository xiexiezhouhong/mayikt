package com.mayikt.thread.days03;

public class Thread06 {
    private Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread06 thread06 = new Thread06();
        Thread thread = thread06.print();
        thread.start();
        try {
            Thread.sleep(3000);
            // 中断线程
            thread.interrupt();
        } catch (Exception e) {

        }

    }

    public Thread print() {
        Thread thread = new Thread(() -> {
            synchronized (object) {
                System.out.println("1");
                try {
                    object.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
        return thread;
    }


}