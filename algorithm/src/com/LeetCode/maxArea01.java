package com.LeetCode;

public class maxArea01 {

    public static void main(String[] args) {
        maxArea01 max = new maxArea01();
        int[] array = {1,8,6,2,5,4,8,3,7};
        int i = max.maxArea(array);
        System.out.println(i);
    }

    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if(Area(height, i, j) > max){
                    max = Area(height, i, j);
                }
            }
        }
        return max;
    }


    public int Area(int[] height, int i, int j) {
        return (j - i) * (Math.min(height[i], height[j]));
    }

    public int maxArea(int[] height){
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            max = Math.max(max, Area(height, l ,r ));
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }

        return max;
    }

}


