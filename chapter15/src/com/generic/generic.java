package com.generic;

import java.util.ArrayList;

/**
 * 没有指定泛型，默认时object
 * 泛型数组不能初始化,因为不知道开辟多大空间
 * 静态方法不能使用泛型
 * 因为静态适合类相关的，在类加载的时候，对象还没有创建
 * 泛型接口在实现和被继承时，泛型必须要指定
 */
public class generic {
    public static void main(String[] args) {
        //E已经绑定了A，但是还可以传入其子类
        pig<A> A_pig = new pig<A>(new A());

        pig<A> bpig = new pig<A>(new B());

        //在实际运用中，我们往往可以简写
        //即后面的菱形里可以不写
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<pig> pigs = new ArrayList<>();
    }
}

class A{}

class B extends A{}

class pig<E>{
    E e;

    public pig(E e) {
        this.e = e;
    }
}

interface IUsb<U,R>{
    R get();
    void hi(R r);
}

interface AA extends IUsb<String, Double>{

}


//泛型类可以使用泛型，使用了泛型方法的类也不用声明为泛型类
class AaAA<T,V> implements AA{

    @Override
    public Double get() {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }
    //泛型方法
    public <U,R>void eat(){
        System.out.println();
    }
    //不是泛型方法，只是使用了泛型的普通方法
    public void cat(T t){

    }
}
