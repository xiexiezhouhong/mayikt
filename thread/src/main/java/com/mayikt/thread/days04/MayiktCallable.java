package com.mayikt.thread.days04;

/**
 * @author 余胜军
 * @ClassName MayiktCallable
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface MayiktCallable<V> {
    /**
     * 当前线程 执行完毕 返回的结果
     *
     * @return
     * @throws Exception
     */
    V call() ;
}
