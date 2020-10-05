package com.guaniu.content.chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * Dijkstra 双栈算数表达式求职算法的实现
 * 表达式内容：1.运算符(+ - * / sqrt)
 *            2.左右括号
 *            3.操作符
 */
public class DijkstraExpression {
    public static void main(String[] args){
        execExpression();
    }

    private static void execExpression(){
        Scanner scanner = new Scanner(System.in);
        String expression = ""; // 表达式
        Stack<Double> vals = new Stack<Double>(); // 操作数栈1
        Stack<String> oprs = new Stack<String>(); // 运算符栈
        while (scanner.hasNext()){
            String in = scanner.next(); // 每次读取一个括号、运算符、或者
            if ("(".equals(in)){} // 读入左括号忽略
            else if ( Plus.equals(in) || Substract.equals(in) || Multiple.equals(in) || Divide.equals(in) || Sqrt.equals(in)) {
                oprs.push(in); // 压入运算操作符
            } else if (")".equals(in)){
                String oper = oprs.pop(); // 当前运算符
                Double val = vals.pop();
                Double res = null;
                if (Plus.equals(oper)){
                    res = vals.pop() + val;
                } else if (Substract.equals(oper)){
                    res = vals.pop() - val;
                } else if (Multiple.equals(oper)){
                    res = vals.pop() * val;
                } else if (Divide.equals(oper)){
                    res = vals.pop() / val;
                } else if (Sqrt.equals(oper)){
                    res = Math.sqrt(val);
                }
                vals.push(res);
            } else if ("!".equals(in)){ // 退出标记
                break;
            }else { // 其他作为操作数读入
                vals.push(Double.parseDouble(in)); // 压入操作数栈
            }
            expression += in;
        }

        System.out.println("算数表达式：" + expression);
        System.out.println("运算结果：" + vals.pop());
    }

    private static String Plus = "+"; // 加法运算符
    private static String Substract = "-"; // 减法运算符
    private static String Multiple = "*"; // 乘法运算符
    private static String Divide = "/"; // 除法运算符
    private static String Sqrt = "sqrt"; // 开方运算
}
