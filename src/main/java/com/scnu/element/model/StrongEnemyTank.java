package com.scnu.element.model;

import com.scnu.controller.GameInstance;

import java.awt.*;

/**
 * @file: null.java
 * @author: Yum
 * @date: 2024/7/8
 * @description: 强化的敌方坦克
 */

public class StrongEnemyTank extends EnemyTank {

    public static Image StrongEnemyTank_up = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/StrongEnemyTank_up.png"));
    public static Image StrongEnemyTank_down = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/StrongEnemyTank_down.png"));
    public static Image StrongEnemyTank_left = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/StrongEnemyTank_left.png"));
    public static Image StrongEnemyTank_right = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img/StrongEnemyTank_right.png"));

    public StrongEnemyTank(int x, int y) {
        super(x, y);
        setAddScore(15);
        setAttributes();

    }

    public void setAttributes() {
        switch (GameInstance.difficulty) {
            case "简单":
            case "普通":
                setSpeed(1);
                setHp(2);
                break;
            case "困难":
                setSpeed(2);
                setHp(3);
                break;
            case "地狱":
                setSpeed(2);
                setHp(4);
                break;
        }
    }
}