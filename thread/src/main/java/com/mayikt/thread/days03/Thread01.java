package com.mayikt.thread.days03;

/**
 * @author 余胜军
 * @ClassName Thread01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
    }



    public synchronized void print() throws InterruptedException {
        this.wait();
    }

}
