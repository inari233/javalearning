package com.OOP.encapsulation01.exercise;

class Computer {
    private String CPU = "i9";
    private String memory = "16G";
    private String disk = "4TB";

    public Computer() {
    }

    public Computer(String CPU, String memory, String disk) {
        this.CPU = CPU;
        this.memory = memory;
        this.disk = disk;
    }

    public String getinfo(){
        return " CPU = " + CPU + " memory= " + memory + " disk= " + disk;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}
 class PC extends Computer{
    String brand = "Lenovo";

     public PC() {
     }

     public PC(String CPU, String memory, String disk, String brand) {
         super(CPU, memory, disk);
         this.brand = brand;
     }

     public void getPcinfor(){
         System.out.println(getinfo() + " brand= " + brand);
     }
 }

 class NotePad extends PC{
    String color = "red";

     public NotePad() {

     }

     public NotePad(String CPU, String memory, String disk, String brand, String color) {
         super(CPU, memory, disk, brand);
         this.color = color;
     }
 }

