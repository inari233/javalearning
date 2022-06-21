package com.interface_.encapasalution_and_interface;

/**
 * 继承的传递
 */
public class test04 {
    public static void main(String[] args) {
        iG i = new h();
    }
}

interface iG{
    public void hi();
}
interface IH extends iG{
    public void ha();
}
class h implements IH{
    @Override
    public void hi() {

    }

    @Override
    public void ha() {

    }
}
