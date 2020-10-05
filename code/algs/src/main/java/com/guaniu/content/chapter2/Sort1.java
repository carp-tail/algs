package com.guaniu.content.chapter2;

/**
 * 排序
 */
public class Sort1 {
    public static void main(String[] args){
        Integer[] arr = {43,12,32,13,45,123,5,4123,44,3123};
//        selectionSort(arr); 选择排序
//        insertionSort(arr); 插入排序
        shellSort(arr, 2);
        show(arr);
        System.out.println("数组是否排序：" + isSort(arr));
    }

    /**
     * 初级排序算法 1 （选择排序）
     * 数组分为了两部分：已排序部分和未排序部分，每次从未排序部分中挑选出最小的元素，放入已排序部分的最后位置，索引位置加1
     * 选择排序不会再访问索引位置左侧的元素
     * @param arr
     */
    public static void selectionSort(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++) {
            int min = i;
            for (int j = i; j < arr.length; j ++) {
                if (less(arr[j] , arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min); // 交换位置
        }
    }

    /**
     * 初级排序算法 2 （插入排序）
     * 数组分为两个部分：已排序部分和未排序部分，每次将未排序部分的头部元素插入至已排序部分的指定位置，索引位置加1
     * 插入排序不会访问索引位置右侧的元素
     * @param arr
     */
    public static void insertionSort(Comparable[] arr){
        for (int i = 1; i < arr.length; i ++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j --) {
                exchange(arr, j, j - 1); // 交换 j 和 j-1 位置的元素
            }
        }
    }

    /**
     * 初级排序算法 3 （希尔排序）
     * 实现思想： 使数组中间隔 gap的元素都是有序的，使用的还是插入排序的思想
     * 在乱序的情况下比插入排序更快
     * @param arr
     */
    public static void shellSort(Comparable[] arr, int factor){
        int n = arr.length;
        int gap = 1;
        while (gap < n/factor) {
            gap = gap * factor + 1;
        }
        while (gap >=1) {
            for (int i = gap; i < n; i ++) {
                for (int j = i; j >= gap && less(arr[j], arr[j - gap]); j -= gap) {
                    exchange(arr, j, j - gap);
                }
            }
            gap /= factor;
        }
    }

    /**
     * a 若比 b小，返回true，否则返回 false
     * @param a 可比较参数a
     * @param b 可比较参数b
     * @return 返回 a 是否比 b 小
     */
    private static boolean less(Comparable a, Comparable b){
        // a < b 返回 -1
        // a = b 返回 0
        // a > b 返回 1
        return a.compareTo(b) < 0;
    }

    /**
     * 交换 Comparable数组中两个指定位置元素的位置
     * @param arr 数组
     * @param i 元素位置i
     * @param j 元素位置j
     */
    private static void exchange(Comparable[] arr, int i, int j){
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印单行数组
     * @param arr
     */
    private static void show(Comparable[] arr){
        for (Comparable c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序
     * @param arr
     * @return
     */
    private static boolean isSort(Comparable[] arr){
        if (arr == null || arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i ++) {
            if (less(arr[i + 1], arr[i])) {
                return false;
            }
        }
        return true;
    }
}
