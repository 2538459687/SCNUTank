package com.scnu.view;

import com.scnu.controller.GameInstance;
import com.scnu.database.User;
import com.scnu.database.UserMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.scnu.game.Application.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @file: null.java
 * @author: Yum
 * @date: 2024/7/8
 * @description: 主角坦克死亡后的菜单
 */

public class OverMenuPanel extends JPanel {
    private final MainFrame mainFrame;
    private GameInstance gameInstance;

    int isGetscore=0;


    JButton menuButton = new JButton("回到菜单");

    JButton restartButton = new JButton("重新游戏");
    JButton endGameButton = new JButton("结束游戏");

    JButton rankListButton = new JButton("查看排行榜");

    public OverMenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        menuButton.setForeground(Color.WHITE);
        menuButton.setFont(new Font("幼圆", Font.PLAIN, 20));
        menuButton.setBackground(new Color(1, 85, 157));
        menuButton.addActionListener(new menuButtonHandler());
        this.add(menuButton);

        restartButton.setForeground(Color.WHITE);
        restartButton.setFont(new Font("幼圆", Font.PLAIN, 20));
        restartButton.setBackground(new Color(1, 85, 157));
        restartButton.addActionListener(new restartButtonHandler());
        this.add(restartButton);

        endGameButton.setForeground(Color.WHITE);
        endGameButton.setFont(new Font("幼圆", Font.PLAIN, 20));
        endGameButton.setBackground(new Color(1, 85, 157));
        endGameButton.addActionListener(new endGameButtonHandler());
        this.add(endGameButton);

        rankListButton.setForeground(Color.WHITE);
        rankListButton.setFont(new Font("幼圆", Font.PLAIN, 20));
        rankListButton.setBackground(new Color(1, 85, 157));
        rankListButton.addActionListener(new rankListButtonHandler());
        this.add(rankListButton);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 700);

        g.setColor(Color.black);
        g.setFont(new Font("幼圆", Font.BOLD, 45));
        if(isGetscore==-1){
            g.drawString("网络异常无法上传分数", 180, 100);
        }
        g.drawString(playerName + "的分数为" + gameInstance.calculateScore(), 240, 180);


        menuButton.setSize(260, 40);
        menuButton.setLocation(250, 300);
        restartButton.setSize(260, 40);
        restartButton.setLocation(250, 370);
        endGameButton.setSize(260, 40);
        endGameButton.setLocation(250, 440);
        rankListButton.setSize(260, 40);
        rankListButton.setLocation(250, 510);
        menuButton.requestFocus();
        restartButton.requestFocus();
        endGameButton.requestFocus();
        rankListButton.requestFocus();
        System.out.println("repaint");
        if (!isUpdate) {
            isGetscore = updateUser(gameInstance);
            isUpdate = true;
        }

    }
    class menuButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            isInput = false;
            restart = true;
        }
    }


    class restartButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            isInput = true;
            restart = true;
        }
    }

    class endGameButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    class rankListButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (WelMenuPanel.isLocal ) {
                showMessageDialog(mainFrame,
                        "离线游戏\n无法查看排行榜", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                RankListPanel rankListPanel = new RankListPanel(mainFrame);
                if(rankListPanel.getRankListTable()==null){
                    showMessageDialog(mainFrame,
                            "网络异常\n无法查看排行榜", "提示",
                            JOptionPane.INFORMATION_MESSAGE);
                }else {
                    VIEW_CONTROL.rankListShow(rankListPanel);
                }

            }
        }
    }

    public int updateUser(GameInstance gameInstance) {
        if (!WelMenuPanel.isLocal) {
            System.out.println("update");

            User u = new User(playerName, gameInstance.calculateScore(), GameInstance.difficulty);

            if(UserMethod.getScore(u.getUsername(), GameInstance.difficulty)==-1){
                return -1;
            } else if (UserMethod.getScore(u.getUsername(), GameInstance.difficulty) < u.getScore()) {
                UserMethod.updateUser(u);
            }
        }
        return 0;
    }

    public GameInstance getGameInstance() {
        return gameInstance;
    }

    public void setGameInstance(GameInstance gameInstance) {
        this.gameInstance = gameInstance;
    }
}

