package com.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * List<?>表示任何泛型都可以接收
 * List<? extends A>表示可以接受A或者实继承了A的子类,表示规定了上限
 */

public class generic04 {
    public static void main(String[] args) {
        AA1 aa1 = new AA1();
        AA2 aa2 = new AA2();
        List<? extends AA1> list = new ArrayList<>();

    }
}


class AA1{

}
class AA2 extends AA1{

}
