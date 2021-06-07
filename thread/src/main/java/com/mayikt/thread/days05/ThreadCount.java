package com.mayikt.thread.days05;

/**
 * @author 余胜军
 * @ClassName ThreadCount
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ThreadCount implements Runnable {
    private static MayiktLock mayiktLock = new MayiktLock();
    private static int count = 100;
    private Object objectLock = new Object();

    /**
     * 如何保证线程一直在运行状态 死循环控制
     */
    @Override
    public void run() {
        while (true) {
            try {
                //运行状态----休眠状态--cpu的执行权让给其他的线程
                // 休眠----运行状态
                Thread.sleep(30);
            } catch (Exception e) {

            }
            cal();
        }
    }

    /**
     * 1.如果将synchronized 加载我们实例方法上 ，则使用this锁
     * 2.如果将synchronized 加载我们静态方法上 ，类名.class
     */
    public static void cal() {
        try {
            mayiktLock.lock();
            ;
            if (count > 1) {
                count--;
                System.out.println(Thread.currentThread().getName() + "," + count);
            }
        } catch (Exception e) {

        } finally {
            mayiktLock.unLock();
            ;
        }

    }

    /**
     * public  void cal() {
     * synchronized（this）{
     * if (count > 1) {
     * count--;
     * System.out.println(Thread.currentThread().getName() + "," + count);
     * <p>
     * }
     * }
     * }
     *
     * @param args
     */
    public static void main(String[] args) {
//        ThreadCount threadCount1 = new ThreadCount();
//        ThreadCount threadCount2 = new ThreadCount();
//        new Thread(threadCount1).start();
//        new Thread(threadCount2).start();
        ThreadCount threadCount1 = new ThreadCount();
        new Thread(threadCount1).start();
        new Thread(threadCount1).start();
    }
}
