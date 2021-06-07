package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread14
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread14 {
    public static void main(String[] args) throws InterruptedException {
        // wait
        new Thread14().cal2();
    }

    public synchronized void cal() throws InterruptedException {
        //synchronized this锁
        // 1.主动释放对象锁synchronized 2.让当前线程变为等待状态
        this.wait();
    }

    public void cal2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
