package com.enum_;

public class enum012 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.getDesc());

    }
}

class Season{
    private String season;
    private String desc;

    public static final Season STRING = new Season("春天","温暖");
    public static final Season WINTER = new Season("冬天","寒冷");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season SUMMER = new Season("夏天","炎热");

    private Season(String season, String desc) {
        this.season = season;
        this.desc = desc;
    }

    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }
}