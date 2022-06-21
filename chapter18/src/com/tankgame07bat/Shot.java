package com.tankgame07bat;

public class Shot implements Runnable{
    int x;//记录子弹的x坐标
    int y;
    int direct;
    int speed = 5;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向改变
            switch (direct){
                case 0://向上
                    y -= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //挡子弹碰到敌人坦克时也应该解释线程

            if(!(x >= 0 && x <= 1000 && y <=750 && y >= 0 && isLive)){
                isLive = false;
                break;
            }
        }
    }
}
