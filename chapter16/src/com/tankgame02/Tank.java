package com.tankgame02;

public class Tank {
    private int x;
    private int y;
    private int direct;//坦克方向，0上 1右 2下 3左
    private int speed = 1;


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //移动方法
    public void moveUP(){
        y -= speed;
    }

    public void moveRight(){
        x += speed;
    }
    public void moveDown(){
        y += speed;
    }
    public void moveLeft(){
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

class Hero extends Tank{

    public Hero(int x, int y) {
        super(x, y);
    }

}
