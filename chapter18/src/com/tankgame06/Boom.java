package com.tankgame06;

public class Boom {
    int x,y;
    int life = 9;//炸弹生命周期
    boolean isLive = true;

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown(){
        if(life > 0){
            life--;
        }else {
            isLive = false;
        }
    }
}
