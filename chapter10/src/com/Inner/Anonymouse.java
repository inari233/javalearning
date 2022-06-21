package com.Inner;

public class Anonymouse {
    public static void main(String[] args) {
        outer outer = new outer();
        outer.hi();
        outer.hi2();

    }
}


class outer{
    private String name;


    public void hi(){
        //tiger的运行类型是IA
        //tiger的编译类型就是匿名内部类outer$1
        /**
         * 底层就是
         * class XXXX implements IA{
         *     public void cry(){
         *         System.out.println("老虎叫");
         *     }
         * }
         */
        //jdk在底层创建了outer$1，立马创建了outer$1的实列并将其地址返回给tiger
        //匿名内部类使用一次就不能在使用了
        IA tiger = new IA(){
            @Override
            public void cry() {
                System.out.println("老虎叫");
            }
        };
        tiger.cry();
        System.out.println("tiger的运行类型是" + tiger.getClass());

    }

    public void hi2(){
        //编译类型是Father
        //运行类型是outer$2
        /**
         * 在底层就是
         * class outer$2 extends Father{
         *     public void test() {
         *                 System.out.println("重新改写");
         *             }
         * }
         */
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("重新改写");
            }
        };
        father.test();
//      第二种使用方式
        //因为匿名内部类本身返回的也是一个对象
        //遵守动态绑定机制
        new Father("jack"){
            @Override
            public void test() {
                System.out.println("重新改写");
            }

            public void madd(){

            }
        }.madd();
    }
}


interface IA{
    public void cry();
}

class Father{
    private String name;

    public Father(String name) {
        this.name = name;
    }

    public void test(){

    }
}