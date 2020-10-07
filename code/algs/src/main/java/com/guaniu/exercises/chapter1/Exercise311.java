package com.guaniu.exercises.chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 编写一段程序EvaluatePostfix，从标准输人中得到一个后序表达式，求值并打印结果
 * 后缀表达式不需要“(”、“)”
 */
public class Exercise311 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Double> stack = new Stack<Double>();
        while (sc.hasNext()){
            String in = sc.next();
            if ("+".equals(in)){
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(in)){
                stack.push(stack.pop() - stack.pop());
            }else if ("*".equals(in)){
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(in)){
                stack.push(stack.pop() / stack.pop());
            }else if ("!".equals(in)){
                break;
            }else {
                stack.push(Double.parseDouble(in));
            }
        }
        System.out.println(stack.pop());
    }
}
