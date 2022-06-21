package com.enum_.exercise05;

import java.util.Scanner;

class test05 {
    public static void main(String[] args) {
        String weather;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入遇到的天气");
        weather = scanner.next();
        VehiclesFactory vehiclesFactory = VehiclesFactory.getInstance();




    }

}

public interface Vehicles {
    public void work();
}

class Horse implements Vehicles {

    public Horse() {
    }

    @Override
    public void work() {
        System.out.println("骑马");
    }
}

class Boat implements Vehicles {

    public  Boat() {
    }

    @Override
    public void work() {
        System.out.println("划船");
    }
}

class VehiclesFactory {
    private static VehiclesFactory vehiclesFactory = new VehiclesFactory();

    private VehiclesFactory() {
    }

    public static VehiclesFactory getInstance() {
        return vehiclesFactory;
    }

    public static Horse getHorse() {
        return new Horse();
    }

    public static Boat getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
}
