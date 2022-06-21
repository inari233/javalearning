package com.PolandNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reverse {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        List<String> fina = new ArrayList<>();
        Stack<Double> res = new Stack<>();
        double num1;
        double num2;

        String str = "1+((2.8+2.2)*4)-5";
        List<String> list = stringToList.toList(str);
        System.out.println(list);
        for (String s : list) {
            if(s.matches("(\\d+\\.\\d+)|(\\d+)")){
                fina.add(s);
            }
            if(s.matches("[+/*-]")){
                if(stack.size() == 0){
                    stack.push(s);
                    continue;
                }

                if(Priority.priority(s) <= Priority.priority(stack.peek())){
                    fina.add(stack.pop());
                    stack.push(s);
                } else {
                    stack.push(s);
                }
            } else if (s.matches("\\(")) {
                stack.push(s);
            } else if (s.matches("\\)")) {
                while (!stack.peek().equals("(")){
                    fina.add(stack.pop());
                }
                stack.pop();
            }
        }
        while (stack.size() > 0){
            fina.add(stack.pop());
        }

        for (String s2 : fina) {
            if(s2.matches("(\\d+\\.\\d+)|(\\d+)")){
                res.push(Double.parseDouble(s2));
            } else if (s2.matches("[+-/*]")) {
                num1 = res.pop();
                num2 = res.pop();
                res.push(Calculate.calculate(num1, num2, s2));
            }
        }
        System.out.println(res.pop());

    }
}

/**
 * 正则表达式真的好用
 */
class stringToList{
    public static List<String> toList(String s){
        List<String> list = new ArrayList<>();
        //使用正则表达式将计算式对应的list转换
        String regStr1 = "((\\d+\\.\\d+)|(\\d+)|([+\\-*/()]))";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            list.add(matcher.group());
        }
        return list;
    }
}

class Priority{
    public static int priority(String s){
        if(s.matches("[+-]")){
            return 1;
        }
        if(s.matches("[/*]")){
            return 2;
        }
        if(s.matches("[()]")){
            return 0;
        }
        throw new RuntimeException("表达式错误");
    }
}

class Calculate{
    public static double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num1 * num2;
            case "/":
                return num2 / num1;
        }
        throw new RuntimeException("表达式错误");
    }
}