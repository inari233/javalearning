package com.enum_.exercise06;
class exercise06{
    public static void main(String[] args) {
        car car = new car(20);
        car.air air = car.new air();
        air.flow();
    }


}

public class car {
    private int temperature;

    public car(int temperature) {
        this.temperature = temperature;
    }

    class air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷风");
            } else if (temperature < 0) {
                System.out.println("吹热风");
            }else {
                System.out.println("关闭空调");
            }
        }
    }

    public air getAir(){
        return new air();
    }
}
