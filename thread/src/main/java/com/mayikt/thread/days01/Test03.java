package com.mayikt.thread.days01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 余胜军
 * @ClassName Test03
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test03 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "我是子线程"));
    }
}
