package com.final_;

/**
 * final变量赋初值的时候
 * 1.在定义时
 * 2.在构造器中
 * 3.在代码块里
 */
public class detail01 {
    public static void main(String[] args) {

    }
}

class AA {
    public final double TEX_RATE1 = 0.08;//第一张
    public final double TEX_RATE2;
    public final double TEX_RATE3;

    {
        TEX_RATE3 = 0.08;//第三种
    }
    public AA() {
        TEX_RATE2 = 0.08;//第二种
    }
}

/**
 * 静态常量final赋初值的时候
 * 1.定义时
 * 2.静态代码块里
 * 3.不能在构造器里
 * 因为静态成员在类加载的时候就有了
 */
class CC{
    public static final double TEX_TATE = 0.08;
    public static final double TEX_TATE2;

    static {
        TEX_TATE2 = 0.08;
    }

}

/**
 * final类不能继承，可以被实例化对象
 * 如果类不是final类，但是有final方法，虽然方法不能被重写，但是可以被继承
 */

