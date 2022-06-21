package com.wrapper.exercise01;

public class exercise01 {
    public static void main(String[] args) {
        String str = "abcedfghf";

        try {
            String str2 = MyTool.reverse(str, 1, 7);
            System.out.println(str2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}

class MyTool {

    public static String reverse(String str, int begin, int end) {

        //对输入参数的一个验证
        //重要编程思想！！！
        //（1）写出正确的情况
        //（2）然后取反即可
        //（3）这样写思路会很清晰
        if(!(str != null && begin > 0 && end > begin && end < str.length())){
            throw new RuntimeException("参数不正确");
        }
        char temp = ' ';
        char[] str1 = str.toCharArray();
        for (int arrBegin = begin, arrEnd = end; arrEnd - arrBegin > 0; ++arrBegin, --arrEnd) {
            temp = str1[arrBegin];
            str1[arrBegin] = str1[arrEnd];
            str1[arrEnd] = temp;
        }
        return new String(str1);
    }
}
