package com.guaniu.exercises.chapter1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 编写一段程序，从标准输人得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输人：
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * 你的程序应该输出：
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Exercise309 {
    /**
     * 实现思路：遇到“)”，弹出前面三个前后加上“(”、“)”重新压入，遇到其他的直接压入
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        while (sc.hasNext()){
            String str = sc.next();
            if ("!".equals(str)){
                break;
            } if (")".equals(str)){
                String num2 = stack.pop();
                String oper = stack.pop();
                String num1 = stack.pop();
                stack.push("(" + num1 + oper + num2 + ")");
            } else {
                stack.push(str);
            }
        }
        System.out.println(stack.pop());
    }
}
