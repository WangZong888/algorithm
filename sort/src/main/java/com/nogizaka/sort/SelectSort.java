package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

public class SelectSort {

    public static void main(String[] args) {
        // TODO: 2019/07/28 创建数组
//        int[] arr = ArrayUtils.createArray(10, 100);
        int[] arr = ArrayUtils.createArray(10_0000, 100 * 10000);
        ArrayUtils.print(arr);
        // TEST 2019/07/28 测试时间
        long start = System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("time : %d ms\n", end - start);
        // TODO: 2019/07/28 打印数组
        ArrayUtils.print(arr);
    }

    /**
     * 选择排序 - 最小值放左边，变量保存最小值
     * @param arr 数组
     */
    private static void selectSort(int[] arr) {
        // READY 2019/07/28 最小值，最小索引
        int minIndex;

        // TODO: 2019/07/28 每轮
        for (int i = 0; i < arr.length - 1; i++) {
            // WARN !! 重置
            minIndex = i;
            // TODO: 2019/07/28 向后比
            for (int j = i + 1; j < arr.length; j++) {
                // TODO: 2019/07/28 判断交换索引
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            // TODO: 2019/07/28  判断交换数值
            if (minIndex != i) ArrayUtils.swap(arr, minIndex, i);
        }
    }
}
