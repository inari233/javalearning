package com.tankgame05;

import java.util.Vector;

public class Tank {
    private int x;
    private int y;
    private int direct;//坦克方向，0上 1右 2下 3左
    private int speed = 100;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //移动方法
    public void moveUP() {
        if (y - speed <= 0) {
            return;
        }
        y -= speed;
    }

    public void moveRight() {
        if (x + speed >= 1000) {
            return;
        }
        x += speed;
    }

    public void moveDown() {
        if (y + speed >= 750) {
            return;
        }
        y += speed;
    }

    public void moveLeft() {
        if (x - speed <= 0) {
            return;
        }
        x -= speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

/**
 * 自己的坦克hero
 */

class Hero extends Tank {
    //定义一个shot对象
    Vector<Shot> shots = new Vector<>();


    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnemyTank() {
        //创建Shot对象
        switch (getDirect()) {
            case 0:
                shots.add(new Shot(getX() + 20, getY(), 0));
                break;
            case 1:
                shots.add(new Shot(getX() + 60, getY() + 20, 1));
                break;
            case 2:
                shots.add(new Shot(getX() + 20, getY() + 60, 2));
                break;
            case 3:
                shots.add(new Shot(getX(), getY() + 20, 3));
                break;
        }
        for (Shot shot : shots) {
            Thread thread = new Thread(shot);
            thread.start();
        }

    }

}
