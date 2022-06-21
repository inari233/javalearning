package com.recurion.QueensOfDeath;

import java.util.Arrays;

public class Queens {
    public static void main(String[] args) {
        int[] chess = new int[8];
        count count = new count();
        count.findWay(chess, 1);
        System.out.println(count.ways);
    }
}

class count{
    int ways = 0;
    public void findWay(int[] chess,int i){
        if(i == 8){
            ++ways;
            return;
        }

        for (int k = 0; k < 8; k++) {
            if(!contain(chess, k)){
                chess[i] = k;
                findWay(chess, i + 1);
            }
        }


    }


    public boolean contain(int[] chess, int i){
        for (int chess1 : chess) {
            if(chess1 == i){
                return true;
            }
        }
        return false;
    }
}

