package com.guaniu.common;

public class Utils {
    /**
     * [计算最大公约数（欧几里德算法）]
     * 题目描述：
     * 计算两个非负整数p 和q 的最大公约数：若
     * q 是0，则最大公约数为p。否则，将p 除以
     * q 得到余数r，p 和q 的最大公约数即为q 和
     * r 的最大公约数。
     */
    public static int findHighestCommonFactor(int p, int q){
        if (q == 0) { // 被除数为0时，除数即为最大公约数
            return p;
        }
        return findHighestCommonFactor(q, p % q);
    }
}
