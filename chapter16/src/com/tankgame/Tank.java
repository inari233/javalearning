package com.tankgame;

public class Tank {
    private int x;
    private int y;

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
