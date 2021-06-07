package com.mayikt.thread.days02;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    private Object objectLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Test01().print();

    }

    public void print() throws InterruptedException {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + ">1<");
                /**
                 *         this.wait();释放锁资源 同时当前线程会阻塞
                 *          this.wait()、notify 需要放到synchronized同步代码中使用
                 */
                // 获取到锁的对象.wait
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ">2<");
            }
        }).start();

        try {
            Thread.sleep(3000);
            // 主线程3s 之后唤醒该子线程
            synchronized (objectLock) {
                objectLock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
