package com.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 演示小球通过键盘控制上下左右移动 -> 讲解java事件控制
 */
public class BallMove extends JFrame{
    MyPanel mp = null;

    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //该对象可以监听键盘事件，既可以监听到面板上发生的事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
//
class MyPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    /**
     * 根据用户输入的不同键位进行输出
     * @param e the event to be processed
     */

    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下,该方法就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){//对应的就是键盘的向下箭头
            y++;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x--;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x++;
        }
        //让面板重绘
        this.repaint();

    }
    //当某个键松开了就会触发
    @Override
    public void keyReleased(KeyEvent e) {
       // System.out.println((char)e.getKeyCode());
    }
}
