package com.houserent;

import com.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView类.是程序的入口
        new HouseView().mainMenu();
        System.out.println("===你退出房屋出租系统===");
    }
}
