package com.guaniu.content.chapter1;

/**
 * 1.1.10 二分查找
 * 需要有序数组
 */
public class BinarySearch {

    private int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]){
                hi = mid - 1;
            } else if (key > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
