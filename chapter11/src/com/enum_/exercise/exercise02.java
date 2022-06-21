package com.enum_.exercise;

public class exercise02 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week week:weeks
             ) {
            System.out.println(week.getDesc());
        }

    }
}

enum Week{

    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"),
    THURSDAY("星期四"),FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期天");
    private String desc;

    Week(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
