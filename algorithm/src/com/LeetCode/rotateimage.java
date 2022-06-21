package com.LeetCode;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 */
public class rotateimage {
    public static void main(String[] args) {

    }
    public void rotate1(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //在按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }



    public void rotate(int[][] matrix){
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < matrix[j].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints, 0, ints.length - 1);
        }

    }

    public void reverse(int[] array, int left, int right){
        while (left > right){
            int t = array[left];
            array[left] = array[right];
            array[right] = t;
            left++;
            right--;
        }
    }

}
