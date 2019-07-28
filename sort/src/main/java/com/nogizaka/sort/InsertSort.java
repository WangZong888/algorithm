package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 创建数组
//        int[] arr = ArrayUtils.createArray(10, 100);
        int[] arr = ArrayUtils.createArray(10_0000, 100 * 10000);
        ArrayUtils.print(arr);
        // TEST 2019/07/28 测试时间
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("time : %d ms\n", end - start);
        // TODO: 2019/07/28 打印数组
        ArrayUtils.print(arr);
    }

    private static void insertSort(int[] arr) {
        // READY 2019/07/28 插入索引，插入数值
        int insertIndex, insertValue;
        // TODO: 2019/07/28 第2个 -> 往前比
        for (int i = 1; i < arr.length; i++) {
            // WARN !! 2019/07/28 重置
            insertIndex = i - 1;
            insertValue = arr[i];
            // TODO: 2019/07/28 寻找位置 -> 移动
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex--];
            }
            // TODO: 2019/07/28 找到位置 -> 赋值
            arr[insertIndex + 1] = insertValue;
        }
    }
}
