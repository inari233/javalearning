package com.Inner.exercise;
class tests{
    public static void main(String[] args) {
        CellPhone.test();
        CellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("汽车了");
            }
        });
    }
}

public interface Bell {
    public void ring();
}

class CellPhone{
    public static void alarmclock(Bell bell){
        bell.ring();
    }

    public static void test(){
        alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("篮子快起床");
            }
        });

        alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
