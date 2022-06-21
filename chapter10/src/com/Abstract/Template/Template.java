package com.Abstract.Template;

/**
 * 只需要用重现类重写子类的job方法，calculate里就会由动态绑定机制自动调用子类重写的job方法
 */
abstract public class Template {
    //抽象类，对应的就是模板设计模式

    public abstract void job();

    public void calculateTime(){
        //得到开始的时间
        long start = System.currentTimeMillis();
        job();
        //得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("执行时间为" +  (end - start));
    }

}
