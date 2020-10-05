package com.guaniu.exercises.chapter1;

public class Exercise09 {
    public static void main(String[] args){
        System.out.println(decimalToBinary(3029737));
    }

    /**
     * 十进制正数转换为二进制
     * @param n
     * @return
     */
    private static String decimalToBinary(int n){
        String s = "";
        while (n > 0) {
            s = (n % 2)  + s;
            n = n >> 1; // n = n / 2;
        }
        return s;
    }
}
