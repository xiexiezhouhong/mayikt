package com.mayikt.thread.days04;

/**
 * @author 余胜军
 * @ClassName MayiktCallableImpl
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MayiktCallableImpl implements MayiktCallable<Integer> {

    @Override
    public Integer call()  {
        try {
            System.out.println(Thread.currentThread().getName() + ",子线程在执行耗时的代码");
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        // 耗时代码执行完毕之后 返回1
        return 1;
    }
}
