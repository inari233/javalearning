package com.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//编程时以不正确的条件作为判断退出，不要把正确的条件作为判断。
//只要满足退出的条件就直接break，然后下面在if外再进行通过条件的处理
public class SmallChangeSys {

    //1，先完成菜单，并可以选择菜单

    public static void main(String[] args) {

        //定义相关的变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//可以用于日期格式化
        do{

            System.out.println("=======零钱通菜单=======");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.println("请选择(1-4):");
            key = scanner.next();



            //使用switch
            switch (key){
                case"1" :
                    System.out.println("1 零钱通明细");
                    break;
                case"2" :
                    date = new Date();
                    System.out.println(sdf.format(date));
                    System.out.println("2 收益入账");
                    break;
                case "3" :

                System.out.println("3 消费");
                    break;
                case "4" :
                    System.out.println("4 退出");
                    loop = false;
                    break;
                default:
                    System.out.println("菜单选择有误，请重写选择");
            }
        }while (loop);
        System.out.println("退出了零钱通");
    }
}
