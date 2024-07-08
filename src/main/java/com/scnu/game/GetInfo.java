package com.scnu.game;

import java.awt.*;

import static com.scnu.game.Attributes.OBJECT_SIZE;

/**
 * @file: null.java
 * @author: Yum
 * @date: 2024/7/8
 * @description: 获取对象的位置与贴图 进行匹配绘制
 */

public interface GetInfo {

    // 获取对象的位置与贴图,方便统一绘制与检测

    int getX();

    int getY();

    Image getImage();

    void setLive(boolean live);

    boolean isLive();

    default int[] toSimpleDot() {

        int[] dot = new int[2];
        dot[0] = getX() / OBJECT_SIZE;
        dot[1] = getY() / OBJECT_SIZE;

        return dot;
    }
}

