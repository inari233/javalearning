package com.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战绘图区域
 */

//为了监听键盘
public class MyPanel extends JPanel implements KeyListener {
    //定义自己的坦克
    Hero hero = null;

    //定义敌人的坦克
    Vector<Enemytank> enemytanks = new Vector<>();
    public int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            Enemytank enemytank = new Enemytank(100 * (i + 1), 0);
            enemytank.setDirect(2);
            enemytanks.add(enemytank);
        }
        hero.setSpeed(2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画出自己的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //画出敌人的坦克
        for (int i = 0; i < enemytanks.size(); i++) {
            //取出坦克
            Enemytank enemytank = enemytanks.get(i);
            drawTank(enemytank.getX(), enemytank.getY(), g, enemytank.getDirect(), 0);
        }
    }

    /**
     * @param x         坦克左上角x坐标
     * @param y         坦克左上角y坐标
     * @param g         画笔
     * @param direction 坦克方向
     * @param type      坦克类型
     */

    //画出坦克
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向来绘制坦克
        switch (direction) {
            case 0://表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理方向键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {//按下按键
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变坦克方向
            hero.setDirect(0);
            hero.moveUP();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            //调用发射子弹功能
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
