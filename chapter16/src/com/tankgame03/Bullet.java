package com.tankgame03;

public class Bullet extends Thread{
    private int x;
    private int y;
    int speed = 1;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (true) {
            if(y <= 0){
                break;
            }
            y -= speed;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
