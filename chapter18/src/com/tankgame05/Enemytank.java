package com.tankgame05;

import java.util.List;
import java.util.Vector;

public class Enemytank extends Tank implements Runnable {
    public Vector<Shot> shots = new Vector<>();

    public Enemytank(int x, int y) {
        super(x, y);
    }

    public void shotHeroTank() {
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

    @Override
    public void run() {
        while (true) {
            int n = (int) (Math.random() * 4);

            shotHeroTank();
            switch (n) {
                case 0:
                    setDirect(0);
                    moveUP();
                    break;
                case 1:
                    setDirect(1);
                    moveRight();
                    break;
                case 2:
                    setDirect(2);
                    moveDown();
                    break;
                case 3:
                    setDirect(3);
                    moveLeft();
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
