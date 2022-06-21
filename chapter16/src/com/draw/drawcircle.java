package com.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 演示如何在面板上画圆
 */

public class drawcircle extends JFrame{

    //定义一个面板
    private MyPanel myPanel = null;
    public static void main(String[] args) {
        new drawcircle();
    }

    public drawcircle() {
        myPanel = new MyPanel();

        this.add(myPanel);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

/**
 * 1.MyPanel 对象就是一个画板
 * Graphics g就是一支画笔
 * Graphics 提供了很多绘图方法
 */

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        g.drawOval(10, 10, 100, 100);
    }
}
