package com.tankgame02;

import javax.swing.*;

public class TankGame02 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame02 tankGame02 = new TankGame02();

    }

    public TankGame02(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);//让jFrame监听
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }



}
