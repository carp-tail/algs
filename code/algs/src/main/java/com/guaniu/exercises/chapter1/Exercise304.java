package com.guaniu.exercises.chapter1;

import java.util.Stack;

/**
 * 编写一个 Stack的用例 Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括
 * 号是否配对完整。例如，对于[ ( ) ] { } { [ ( ) ( ) ] ( ) } 程序应该打印 true，对于[ ( ] )则打印
 * false
 */
public class Exercise304 {
    public static void main(String[] args){
        System.out.println(isPair("[()]{}{[()()]()}"));
        System.out.println(isPair("[(])"));
    }

    public static boolean isPair(String str){
        Stack<Character> parentheses = new Stack<Character>();
        for (int i = 0;i < str.length();i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                parentheses.push(c);
            } else if (c == ')') {
                char cc = parentheses.pop();
                if (cc != '(') {
                    return false;
                }
            } else if (c == ']') {
                char cc = parentheses.pop();
                if (cc != '[') {
                    return false;
                }
            } else if (c == '}') {
                char cc = parentheses.pop();
                if (cc != '{') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return parentheses.isEmpty();
    }
}
