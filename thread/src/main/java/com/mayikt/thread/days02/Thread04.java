package com.mayikt.thread.days02;

/**
 * @author 余胜军
 * @ClassName Thread04
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Thread04 {
    /**
     * 共享对象 res
     */
    class Res {
        public String userName;
        public char sex;
        /**
         * flag 默认值==false
         * flag false 输入线程 输入值 输出线程
         * flag true 输出线程 输出值
         */
        public boolean flag = false;
    }

    /**
     * 第一次 输出余胜军,男
     * 第二次 输出小薇,女
     * 第三次 输出余胜军,男
     * 第四次 输出小薇,女
     */
    class InputThread extends Thread {
        private Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (res) {
                    if (res.flag) {
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        res.userName = "余胜军";
                        res.sex = '男';
                    } else {
                        res.userName = "小薇";
                        res.sex = '女';
                    }

                    // 输出线程 输出值
                    res.flag = true;
                    // 唤醒输出线程
                    res.notify();
                }
                // 1%2 = 2%2  3%2 4%2=
                count = (count + 1) % 2;

            }

        }
    }

    /**
     * 输出的线程
     */
    class OutPutThread extends Thread {
        private Res res;

        public OutPutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    if (!res.flag) {
                        // 如果 res.flag=false 则 输出的线程 主动释放锁 同时会阻塞该线程
                        try {
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println(res.userName + "," + res.sex);
                    // 输出完毕 交给我们的输入线程继续的输入
                    res.flag = false;
                    res.notify();;

                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread04().print();
    }

    public void print() {
        // 全局对象
        Res res = new Res();
        // 输入线程
        InputThread inputThread = new InputThread(res);
        OutPutThread outPutThread = new OutPutThread(res);
        inputThread.start();
        outPutThread.start();
    }

}
