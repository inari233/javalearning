package com.Calculator;

public class Calculator {
    public static void main(String[] args) {
        String str = "1-10-1-50-50";
        char[] chars = new char[str.length()];
        str.getChars(0, str.length(), chars, 0);
        System.out.println(chars);
        ArrayStackNumber arrayStackNumber = new ArrayStackNumber(50);
        ArrayStackOperator arrayStackOperator = new ArrayStackOperator(50);
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        char op = ' ';
        int i = 0;
        String str1 = "";
        while (true) {
            /**
             * 该算法的关键
             * 当发现栈顶元素的优先即大于或等于要入栈的运算符
             * 就将其出栈，然后数栈也pop出两个数字进行计算，然后入数栈
             * 如果是数字就直接入栈，等到所有的表达式都处理完毕，就可以以此重复pop出一个运算符两个数字
             * 进行运算然后push入数栈，等到符号栈的所有运算符都计算完毕，数栈的最后一个数字就是运算结果
             */
            if (ArrayStackOperator.isOperator(chars[i])) {//判断是不是运算符
                if (arrayStackOperator.isEmpty()) {//判断栈内是否为空
                    arrayStackOperator.push(chars[i]);
                } else {//为空的情况

                    if (arrayStackOperator.priority(chars[i]) <= arrayStackOperator.priority(arrayStackOperator.peek())) {
                        num1 = arrayStackNumber.pop();
                        num2 = arrayStackNumber.pop();
                        op = arrayStackOperator.pop();
                        res = arrayStackNumber.calculate(num1, num2, op);
                        arrayStackNumber.push(res);
                        arrayStackOperator.push(chars[i]);
                    } else {
                        arrayStackOperator.push(chars[i]);
                    }
                }
                ++i;
            } else {//是数字的情况
                /**
                 * 改进为可以处理多位数的情况
                 * 基本思路，可以一直进行拼接，直到遇到运算符位置，再进行截断
                 * 截断的时候一一定要记得对拼接的字符串进行清空
                 */
                str1 += chars[i];
                //如果是表达式的最后一位就直接入栈
                if (i == chars.length - 1) {
                    arrayStackNumber.push(Integer.parseInt(str1));

                } else {
                    if (ArrayStackOperator.isOperator(str.substring(i + 1, i + 2).charAt(0))) {
                        //如果后一位是运算符，就把前面拼接的字符串直接入栈
                        arrayStackNumber.push(Integer.parseInt(str1));
                        str1 = "";
                    }

                }
                ++i;
            }
            if (i == chars.length) {
                break;
            }
        }

        while (true) {
            if (!arrayStackOperator.isEmpty()) {
                num1 = arrayStackNumber.pop();
                num2 = arrayStackNumber.pop();
                op = arrayStackOperator.pop();
                res = arrayStackNumber.calculate(num1, num2, op);
                arrayStackNumber.push(res);
            } else {
                break;
            }
        }

        System.out.println(arrayStackNumber.pop());
    }
}

class ArrayStackOperator {
    public int MaxSize;
    public char[] stack;
    public int top = -1;

    public ArrayStackOperator(int maxSize) {
        MaxSize = maxSize;
        stack = new char[MaxSize];
    }

    public boolean isFull() {
        return top == MaxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        stack[++top] = value;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        return stack[top--];
    }


    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        int t = top;
        while (t != -1) {
            System.out.println(stack[t--]);
        }
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public int priority(char c) {
        if (c == '*' || c == '/') {
            return 1;
        }
        if (c == '+' || c == '-') {
            return 0;
        }
        throw new RuntimeException("不是运算符");
    }

    public char peek() {
        return stack[top];
    }
}


class ArrayStackNumber {
    public int MaxSize;
    public int[] stack;
    public int top = -1;

    public ArrayStackNumber(int maxSize) {
        MaxSize = maxSize;
        stack = new int[MaxSize];
    }

    public boolean isFull() {
        return top == MaxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈慢");
            return;
        }

        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        return stack[top--];
    }


    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        int t = top;
        while (t != -1) {
            System.out.println(stack[t--]);
        }
    }


    public int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
        }
        throw new RuntimeException("表达式错误");
    }
}
