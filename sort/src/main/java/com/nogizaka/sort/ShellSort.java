package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

public class ShellSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 创建 打印
        int[] arr = ArrayUtils.createArray(10000, 100000);
        ArrayUtils.print(arr);
        // TEST 2019/07/28 希尔排序
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("%d个元素耗时：%d ms", arr.length / 10000, end - start);
        // TODO: 2019/07/28 打印
        ArrayUtils.print(arr);
    }

    private static void shellSort(int[] arr) {
        // TODO: 2019/07/28 确定间隔
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // TODO: 2019/07/28 往后排序
            for (int i = gap; i < arr.length; i++) {
                // TODO: 2019/07/28 间隔向前
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) ArrayUtils.swap(arr, j, j + gap);
                }
            }
        }
    }
}
