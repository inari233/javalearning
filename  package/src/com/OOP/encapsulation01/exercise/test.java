package com.OOP.encapsulation01.exercise;

public class test {
    public static void main(String[] args) {
        PC pc = new PC();
        NotePad notePad = new NotePad();

        System.out.println(pc.getCPU());
        System.out.println(notePad.brand);

        notePad.getPcinfor();

    }
}
