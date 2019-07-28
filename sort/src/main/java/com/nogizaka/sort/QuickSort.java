package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

public class QuickSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 创建数组
        int[] arr = ArrayUtils.createArray(10000 * 10000, 10000000);
        // TODO: 2019/07/28 打印数组
//        ArrayUtils.print(arr);
        // TEST 2019/07/28 测试
        long start = System.currentTimeMillis();
        // TODO: 2019/07/28 排序
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.printf("%d万个元素用时：%s 毫秒\n", arr.length / 10000, end - start);
        // TODO: 2019/07/28 打印数组
//        ArrayUtils.print(arr);
    }

    /**
     * 快速排序，指定基数，逐步有序
     *
     * @param arr   数组
     * @param left  最左边
     * @param right 最右边
     */
    private static void quickSort(int[] arr, int left, int right) {
        // READY 2019/07/28 开始索引 & 结尾索引 & 基准值
        int start = left, end = right;
        int pivot = arr[(left + right) / 2];
        // TODO: 2019/07/28 开始查找
        while (start < end) {
            // TODO: 2019/07/28 左右分别向基准找
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            // WARN !! 2019/07/28 退出条件，start >= end -> 查找完成
            if (start >= end) break;
            // TODO: 2019/07/28 交换数值
            ArrayUtils.swap(arr, start, end);
            // TIPS 2019/07/28 交换后判断基准
            if (arr[start] == pivot) end--;
            if (arr[end] == pivot) start++;
        }
        // TIPS 2019/07/28 防止堆溢出
        if (start == end) {
            start++;
            end--;
        }
        // TODO: 2019/07/28 左右递归
        if (left < end) quickSort(arr, left, end);
        if (start < right) quickSort(arr, start, right);
    }
}
