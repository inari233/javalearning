package com.recurion.migong;

public class Maze {
    public static void main(String[] args) {
        findWay findWay = new findWay();
        int[][] maze = new int[7][7];

        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[6][i] = 1;
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[3][2] = 1;
        findWay.saYWay(maze, 1, 1);
        findWay.ShowMaze(maze);
    }
}

class findWay{
    public void ShowMaze(int[][] maze){
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param maze 这是迷宫主体
     * @return 返回值为正则找到路，为零则没用
     * i 是 行，j 是 列
     * 先规定
     */
    public boolean saYWay(int[][] maze, int i, int j){
        if(maze[5][5] == 2){
            return true;
        }
        if(maze[i][j] == 0){
            /**
             * 指定找路规则（下右上左）
             */
            maze[i][j] = 2;
            if(saYWay(maze, i + 1, j)){
                return true;
            } else if (saYWay(maze, i, j + 1)){
                return true;
            } else if (saYWay(maze, i + 1, j)) {
                return true;
            } else if (saYWay(maze, i, j - 1)) {
                return true;
            } else {
                maze[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}