package com.tankgame07bat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战绘图区域
 */

//为了监听键盘
//为了让panel不停的重绘子弹，需要让Mypanel当成线程来使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义自己的坦克
    Hero hero = null;

    //定义敌人的坦克
    Vector<Enemytank> enemytanks = new Vector<>();
    //存放炸弹
    Vector<Boom> booms = new Vector<>();
    public int enemyTankSize = 3;

    //定义三种炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(100, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            Enemytank enemytank = new Enemytank(100 * (i + 1), 0);
            enemytank.setDirect(2);
            Enemytank.enemytanks.add(enemytank);
            //启动
            new Thread(enemytank).start();
            //给该对象加入子弹
            Shot shot = new Shot(enemytank.getX() + 20, enemytank.getY() + 60, enemytank.getDirect());
            //加入子弹
            enemytank.shots.add(shot);
            //立即启动
            Thread thread = new Thread(shot);
            thread.start();

            enemytanks.add(enemytank);
        }

        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画出自己的坦克
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出敌人的坦克
        for (int i = 0; i < enemytanks.size(); i++) {
            //取出坦克
            Enemytank enemytank = enemytanks.get(i);
            if (enemytank.isLive) {
                drawTank(enemytank.getX(), enemytank.getY(), g, enemytank.getDirect(), 0);
                for (int j = 0; j < enemytank.shots.size(); j++) {
                    Shot shot = enemytank.shots.get(j);
                    //绘制子弹
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 3, 3, false);
                    } else {
                        //从Vector移除子弹
                        enemytank.shots.remove(shot);
                    }
                }
            }
        }


        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 3, 3, false);
            } else {
                hero.shots.remove(shot);
            }

        }
        ;
        //如果集合中有炸弹，就要去画
        for (int i = 0; i < booms.size(); i++) {
            //去除炸弹
            Boom boom = booms.get(i);
            //更具当前bomb的live值去画
            if (boom.life > 6) {
                g.drawImage(image1, boom.x, boom.y, 60, 60, this);
            } else if (boom.life > 3) {
                g.drawImage(image2, boom.x, boom.y, 60, 60, this);
            } else {
                g.drawImage(image3, boom.x, boom.y, 60, 60, this);
            }

            //让炸弹生命值减少
            boom.lifeDown();
            //如果生命为零，就从集合中删除
            if (boom.life == 0) {
                booms.remove(boom);
            }
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

    public void hitEnemyTank() {
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);

            //判断是否击中了敌人坦克
            if (hero.shot != null && hero.shot.isLive) {
                //遍历敌人所有的坦克
                for (int i = 0; i < enemytanks.size(); i++) {
                    Enemytank enemytank = enemytanks.get(i);
                    hitTank(hero.shot, enemytank);
                }
            }
        }
    }

    public void hitHero(){
        //遍历所有的敌人坦克
        for (int i = 0; i < enemytanks.size(); i++) {
            Enemytank enemytank = enemytanks.get(i);
            //遍历所有子弹
            for (int j = 0; j < enemytank.shots.size(); j++) {
                Shot shot = enemytank.shots.get(j);
                //判断是否击中
                if(hero.isLive && shot.isLive){
                    hitTank(shot, hero);
                }
            }
        }
    }



    //编写方法，判断我方的子弹是否击中坦克
    //什么时候判断子弹是否击中坦克
    public void hitTank(Shot s, Tank enemytank) {
        //判断s，击中坦克
        switch (enemytank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                if (s.x > enemytank.getX() && s.x < enemytank.getX() + 40
                        && s.y > enemytank.getY() && s.y < enemytank.getY() + 60) {
                    s.isLive = false;
                    enemytank.isLive = false;
                    //当我的子弹击中敌方坦克时，就将其去掉
                    enemytanks.remove(enemytank);
                    //创建一个Bomb对象，加入到集合中
                    Boom boom = new Boom(enemytank.getX(), enemytank.getY());
                    booms.add(boom);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.x > enemytank.getX() && s.x < enemytank.getX() + 60
                        && s.y > enemytank.getY() && s.y < enemytank.getY() + 40) {
                    s.isLive = false;
                    enemytank.isLive = false;
                    //创建一个Bomb对象，加入到集合中
                    Boom boom = new Boom(enemytank.getX(), enemytank.getY());
                    booms.add(boom);
                }
                break;
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
            if (hero.getY() > 0) {
                hero.moveUP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 750) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitEnemyTank();
            hitHero();
            this.repaint();
        }
    }
}
