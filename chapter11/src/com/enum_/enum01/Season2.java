package com.enum_.enum01;

public enum Season2 {
    //定义的常量对象写在最前面
    //如果用的是无参构造器创建对象，则可以省略小括号
    //在底层
    //public static final Season2
    STRING("春天","温暖"),WINTER("冬天","寒冷"),
    WHAT;
    private String season;
    private String desc;

    Season2(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

    Season2() {
    }
}
