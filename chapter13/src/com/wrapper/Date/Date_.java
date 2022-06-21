package com.wrapper.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_ {
    public static void main(String[] args) {
        Date date = new Date();//获得系统当前时间
        //默认输出的格式是国外的
        System.out.println(date);

        //创建SimpleDateFormat对象，可以指点相应的格式
        //格式是固定的，手册有表
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String format = sdf.format(date);
        System.out.println("当前日期是：" + format);

        //1.可以把一个格式化的字符串转化为对应的date
        String s = "1996年01月01日 10:20:30";
        //Date parse = sdf.parse(s);
    }
}
