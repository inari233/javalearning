package com.tankgame07bat;

import java.util.Vector;

public class Enemytank extends Tank implements Runnable {
    //地方坦克子弹
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public static Vector<Enemytank> enemytanks = new Vector<>();


    public Enemytank(int x, int y) {
        super(x, y);
    }

    public boolean isOverlap(){
        for (Enemytank enemytank : enemytanks) {
            switch (getDirect()) {
                case 0://上
                    if(this != enemytank && this.getY() - 10 < enemytank.getY()){
                        return false;
                    }
                    break;
                case 1://右
                    if(this != enemytank && this.getX() + 10 < enemytank.getX()){
                        return false;
                    }
                    break;
                case 2://下
                    if(this != enemytank && this.getY() + 10 < enemytank.getY()){
                        return false;
                    }
                    break;

                case 3:///左
                    if(this != enemytank && this.getX() - 10 < enemytank.getX()){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }


    @Override
    public void run() {
        while (true) {

            //这里我们判断如果shots size
            if (isLive && shots.size() < 3) {
                //判断坦克的方向
                Shot s = null;

                switch (getDirect()) {
                    case 0://上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1://右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2://下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3://左
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && isOverlap()) {
                            moveUP();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000 && isOverlap()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750 && isOverlap()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && isOverlap()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //让后随机地改变坦克方向
            setDirect((int) (Math.random() * 4));
            //一旦写多线程并发程序，一定要考虑清楚该线程什么时候结束
            if (!isLive) {
                break;
            }
        }
    }
}
