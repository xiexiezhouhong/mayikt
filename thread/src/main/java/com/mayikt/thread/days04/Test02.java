package com.mayikt.thread.days04;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 余胜军
 * @ClassName Test02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test02 {
    public static void main(String[] args) {
        //无界队列 无限存放内容
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        blockingDeque.offer("log1");
        blockingDeque.offer("log2");
        // 从队列取出日志
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());
        System.out.println(blockingDeque.poll());

        new Thread().start();
    }
}
