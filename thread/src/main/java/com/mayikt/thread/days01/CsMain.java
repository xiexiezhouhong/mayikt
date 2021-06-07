package com.mayikt.thread.days01;

import javax.swing.*;

/**
 * @author 余胜军
 * @ClassName CsMain
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class CsMain {
    /**
     * 桌面应用的程序开发 c#
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("每特教育");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("每特教育6666");
        frame.getContentPane().add(label);

        // 显示窗口
        frame.pack();
        frame.setVisible(true);
    }
}
