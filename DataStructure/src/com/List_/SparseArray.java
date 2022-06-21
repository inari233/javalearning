package com.List_;

import java.io.*;
import java.util.ArrayList;

public class SparseArray {
    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int[] ints : chess) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                    arrayList.add(anInt);
                }
            }
        }

        int[][] ints = new int[sum + 1][3];
        ints[0][0] = 11;
        ints[0][1] = 11;
        ints[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    ints[count][0] = i;
                    ints[count][1] = j;
                    ints[count][2] = chess[i][j];
                }
            }
        }

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + "  ");
            }
            System.out.println("\n");
        }
        ObjectOutputStream oos = null;
        String filePath = "e:\\c.data";
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(ints);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            int[][] o = (int[][]) ois.readObject();
            for (int[] ints1 : o) {
                for (int i : ints1) {
                    System.out.print(i + "  ");
                }
                System.out.println("\n");
            }
            int[][] chess1  = new int[o[0][0]][o[0][1]];
            for (int i = 1; i < o.length; i++) {
                chess1[o[i][0]][o[i][1]] = o[i][2];
            }
            for (int[] ints1 : chess1) {
                for (int i : ints1) {
                    System.out.print(i + "  ");
                }
                System.out.println("\n");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
