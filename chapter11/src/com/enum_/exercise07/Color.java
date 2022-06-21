package com.enum_.exercise07;
class exercise07{
    public static void main(String[] args) {

        Color green = Color.GREEN;
        green.show();
    }
}

interface machine{
    public void show();
}

public enum Color implements machine{
    RED(255, 0, 0), BLACK(0, 0, 255),
    YELLOW(255, 255, 0), GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(redValue + greenValue + blueValue);
    }
}
