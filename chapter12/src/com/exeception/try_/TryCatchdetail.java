package com.exeception.try_;

public class TryCatchdetail {
    public static void main(String[] args) {
        //快捷键ctrl + atl + t
        try {
            String str = "123";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}

//子类重写父类方法时，抛出的异常要是父类方法的子类或者一样
class F{

    public void method() throws RuntimeException{

    }

}

class S extends F{
    @Override
    public void method()throws RuntimeException {
        super.method();
    }
}