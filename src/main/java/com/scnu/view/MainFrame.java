package com.scnu.view;

import javax.swing.*;
import java.awt.*;

/**
 * @file: null.java
 * @author: Yum
 * @date: 2024/7/8
 * @description: 主界面面板
 */

public class MainFrame extends JFrame {

    public MainFrame(){

        // 设置主程序面板框属性
        setSize(815, 645);
        setTitle("Tank Battle");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/MyTank_up.png")));
    }
}
