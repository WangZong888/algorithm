package com.nogizaka.sort;

import com.nogizaka.utils.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 创建 & 打印
        int[] arr = ArrayUtils.createArray(100000, 10000000);
        int[] temp = new int[arr.length];
        ArrayUtils.print(arr);
        // TEST 2019/07/28 测试
        long start = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, temp);
        long end = System.currentTimeMillis();
        System.out.printf("%d万个元素耗时：%d ms\n", arr.length / 10000, end - start);
        // TODO: 2019/07/28 打印
        ArrayUtils.print(arr);
    }
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // READY 2019/07/28 中间值
        int mid;
        // TODO: 2019/07/28 分解数组
        if (left < right) {
            mid = (left + right) / 2;
            // TODO: 2019/07/28 两侧递归
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // TODO: 2019/07/28 合并数组
            merge(arr, left, mid, right, temp);
        }
    }
    /**
     * 将两个有序数组合并
     * @param arr 原始数组
     * @param left 第一个数组，最左边
     * @param mid 第一个数组，最右边
     * @param right 第二个数组，最右边
     * @param temp 临时数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // READY 2019/07/28 数组端点
        int beginFirst = left, beginSecond = mid + 1, tempIndex = 0;
        // TODO: 2019/07/28 最小拷贝
        while (beginFirst <= mid && beginSecond <= right) {
            // TODO: 2019/07/28 分别拷贝
            if (arr[beginFirst] <= arr[beginSecond]) {
                temp[tempIndex] = arr[beginFirst];
                tempIndex++;
                beginFirst++;
            } else {
                temp[tempIndex] = arr[beginSecond];
                tempIndex++;
                beginSecond++;
            }
        }
        // TODO: 2019/07/28 剩余拷贝
        while (beginFirst <= mid) {
            temp[tempIndex++] = arr[beginFirst++];
        }
        while (beginSecond <= right) {
            temp[tempIndex++] = arr[beginSecond++];
        }
        // TODO: 2019/07/28 拷贝还原
        // READY 2019/07/28 还原遍历
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[tempIndex++];
        }
    }
}
