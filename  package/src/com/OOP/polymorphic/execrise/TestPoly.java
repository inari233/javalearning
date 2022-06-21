package com.OOP.polymorphic.execrise;

public class TestPoly {
    public static void main(String[] args) {
        Employee e1 = new manner("jack", 50000,100000);
        Employee e2 = new usualemployee("jack", 20000);

        Test test = new Test();
        System.out.println(test.showEmpAnnual(e1));
        System.out.println(test.showEmpAnnual(e2));
        test.testwork(e1);
        test.testwork(e2);

        System.out.println(e1.equals(e2));

    }
}

class Test{
    public double showEmpAnnual(Employee e){
        if(e instanceof manner){
            return ((manner)e).getAnnual();
        } else if (e instanceof usualemployee) {
            return ((usualemployee)e).getAnnual();
        }else {
            return e.getAnnual();
        }
    }

    public void testwork(Employee e){
        if(e instanceof manner){
            ((manner)e).manage();
        } else if (e instanceof usualemployee) {
            ((usualemployee)e).work();
        }else {
            System.out.println("啥也不是");
        }
    }
}
