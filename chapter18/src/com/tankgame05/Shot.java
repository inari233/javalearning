package com.tankgame05;

public class Shot implements Runnable{
    int x;//记录子弹的x坐标
    int y;
    int direct;
    int speed = 1;
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
            if(!(x >= 0 && x <= 1000 && y <=750 && y >= 0)){
                isLive = false;
                break;
            }
        }
    }
}
