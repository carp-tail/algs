package com.guaniu.exercises.chapter1;

import com.guaniu.common.Utils;

/**
 * 编写一段程序，创建一个N×N 的布尔数组a[][]。其中当i 和j 互质时（没有相同
 * 因子），a[i][j] 为true，否则为false
 */
public class Exercise30 {
    public static void main(String[] args){
        printResult(8);
    }

    private static void printResult(int n){
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++){
                if (Utils.findHighestCommonFactor(i, j) == 1){ // 计算i和j的最大公约数
                    System.out.print(true);
                } else {
                    System.out.print(false);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
