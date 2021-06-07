package com.mayikt.thread.days01;

import java.util.concurrent.Callable;

/**
 * @author 余胜军
 * @ClassName ThreadCallable
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ThreadCallable implements Callable<Integer> {
    /**
     * 当前线程需要执行的代码 返回结果
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开始执行..");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + "返回1");
        return 1;
    }
}
