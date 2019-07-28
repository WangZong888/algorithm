package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

public class BubbleSort {

    public static void main(String[] args) {
        // TODO: 2019/07/28 创建数组
        int[] arr = ArrayUtils.createArray(100000, 1000000);
        ArrayUtils.print(arr);
        // TEST 2019/07/28 测试时间
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("time : %d ms\n", end - start);
        // TODO: 2019/07/28 打印数组
        ArrayUtils.print(arr);
    }

    /**
     * 冒泡排序
     * @param arr 数组
     */
    private static void bubbleSort(int[] arr) {
        // TODO: 2019/07/28 每轮
        for (int i = 0; i < arr.length - 1; i++) {
            // TODO: 2019/07/28 逐个
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // TODO: 2019/07/28 判断
                if (arr[j] > arr[j + 1]) ArrayUtils.swap(arr, j, j + 1);
            }
        }
    }
}
