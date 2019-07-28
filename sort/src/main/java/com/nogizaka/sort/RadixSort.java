package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 create & print
        int[] arr = ArrayUtils.createArray(8000, 10000000);
//        ArrayUtils.print(arr);
        // TEST 2019/07/28 test
        long start = System.currentTimeMillis();
        // TEST 2019/07/28 基数排序
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("%d万个元素耗时：%d 毫秒\n", arr.length / 10000, end - start);
        // TODO: 2019/07/28 print
        ArrayUtils.print(arr);
    }

    public static void radixSort(int[] arr) {
        // READY 2019/07/28 10个桶，防止溢出，统计个数，最大位数
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int max = arr[0];
        int index;
        // TODO: 2019/07/28 最大位数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int maxLength = (max + "").length();
        // TODO: 2019/07/28 放入，取出
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // TODO: 2019/07/28 放入桶中
            for (int j = 0; j < arr.length; j++) {
                int dig = arr[j] / n % 10;
                bucket[dig][bucketCount[dig]++] = arr[j];
            }
            // TODO: 2019/07/28 放入原数组
            index = 0;
            for (int j = 0; j < bucketCount.length; j++) {
                // TODO: 2019/07/28 有数据放入 
                if (bucketCount[j] != 0) {
                    for (int k = 0; k < bucketCount[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                // WARN !! 2019/07/28 清空数据
                bucketCount[j] = 0;
            }
        }
    }
}
