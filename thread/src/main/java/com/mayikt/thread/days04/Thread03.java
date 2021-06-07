package com.mayikt.thread.days04;

/**
 * @author 余胜军
 * @ClassName Thread03
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread03 {
    public static void main(String[] args) {
        MayiktCallableImpl mayiktCallable = new MayiktCallableImpl();
        MayiktFutureTask<Integer> mayiktFutureTask = new MayiktFutureTask<Integer>(mayiktCallable);
        new Thread(mayiktFutureTask).start();
        Integer result = mayiktFutureTask.get();
        System.out.println(result);
    }
}
