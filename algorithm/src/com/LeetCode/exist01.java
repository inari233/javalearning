package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exist01 {
    public static void main(String[] args) {
        char[][] board = {  {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'E', 'S'},
                            {'A', 'D', 'E', 'E'}};
        exist01 exist01 = new exist01();
        String s = "ABCESEEEFS";
        boolean exist = exist01.exist(board, s);
        System.out.println(exist);
    }


    public boolean exist(char[][] board, String word) {
        //创建一个新的数组，该数组等于原始数组外面围一层空串
        //这样就可以省去边界判断
        char[][] newChars = new char[board.length + 2][board[0].length + 2];
        //创建一个数组，用于保存数组里的某个元素是否被访问过
        //避免重复访问
        boolean[][] isVisited;
        //for嵌套围一圈边界
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newChars[i + 1][j + 1] = board[i][j];
            }
        }
        //对每一个元素dfs
        for (int i = 1; i < newChars.length; i++) {
            for (int j = 1; j < newChars[i].length; j++) {
                //将数组初始化，应该上一次遍历的时候该数组发生了改变
                isVisited = new boolean[newChars.length][newChars[0].length];
                if(exist(i, j, newChars, word, isVisited, 0)){
                    return true;
                }
            }
        }
        //证明没有找到，返回false
        return false;
    }

    public boolean exist(int i, int j, char[][] board, String word, boolean[][] isVisited, int n) {
        //成功的条件
        if (n == word.length()) {
            return true;
        }
        if (board[i][j] == word.charAt(n) && !isVisited[i][j]) {
            //先将该元素置为已经访问访问过
            isVisited[i][j] = true;
            if (exist(i + 1, j, board, word, isVisited, n + 1)) {
                return true;
            }
            if (exist(i - 1, j, board, word, isVisited, n + 1)) {
                return true;
            }
            if (exist(i, j + 1, board, word, isVisited, n + 1)) {
                return true;
            }
            if(exist(i, j - 1, board, word, isVisited, n + 1)){
                return true;
            }
            //到这一步就说明这个元素走不通，换一条路走
            //但是现在这个元素以后在其它路上说不定要用上
            //所以将其置为未访问状态
            isVisited[i][j] = false;
        }
        //和要匹配的字符不同，返回false
        return false;
    }
}
