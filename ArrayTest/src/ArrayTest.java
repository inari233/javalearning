import java.util.Scanner;

public class ArrayTest {
    //使用模板输入main
    //
    public static void main(String[] args) {
//  快捷键alt + s 快速运行
//  ctrl + d 复制当前行到下一行
//  ctrl + y 删除当前行
//  快速格式化 ctrl + alt + l
        MyTools mt = new MyTools();
//      快捷键自动分配变量名+var
        Scanner my_scanner = new Scanner(System.in);
        MyTools myTools = new MyTools();
        int[] arr = {1, 3, 1, 456, 789, 6, 13};
        mt.bubble(arr);
        System.out.println("排序后的arr");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }

}

class Person {
    String name;
    int age;
//    快捷键生成构造器alt + insert

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

class MyTools {
    public void bubble(int[] arr) {
        int t;
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
