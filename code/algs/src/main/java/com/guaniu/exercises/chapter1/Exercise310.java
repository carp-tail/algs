package com.guaniu.exercises.chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 编写一个过滤器InfixToPostfix ,将算术表达式由中序表达式转为后序表达式
 * 前缀表达式需要“(”、“)”保证运算优先级，后缀表达式不需要
 */
public class Exercise310 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        while (sc.hasNext()){
            String in = sc.next();
            if ("+".equals(in) || "-".equals(in) || "*".equals(in) || "/".equals(in)){
                stack.push(in);
            }else if ("(".equals(in)){
            }else if (")".equals(in)){
                String num2 = stack.pop();
                String oper = stack.pop();
                String num1 = stack.pop();
                stack.push(num1 + num2 + oper);
                System.out.println(stack.peek());
            }
            else if ("!".equals(in)){
                break;
            }
            else {
                stack.push(in);
            }
        }
        System.out.println(stack.pop());
    }
}
