package com.CPU;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的CPU数目
        int cupNum = runtime.availableProcessors();
        System.out.println(cupNum);
    }
}
