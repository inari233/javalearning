package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class yanghuiTriangle {
    public static void main(String[] args) {
        yanghuiTriangle ya = new yanghuiTriangle();
        List<List<Integer>> generate = ya.generate(1);
        System.out.println(generate.toString());
    }
    
    
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if(i == 1){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                lists.add(list);
                continue;
            }
            if(i == 2){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(1);
                lists.add(list);
                continue;
            }
            int prev = lists.get(i - 2).get(0);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                int num1 = prev;
                int num2 = lists.get(i - 2).get(j);
                int num3 = num1 + num2;
                prev = num2;
                list.add(num3);
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }
}
