package com.nogizaka.test;

import com.nogizaka.utils.ArrayUtils;

public class TestSort {
    public static void main(String[] args) {
        // TODO: 2019/07/28 创建数组并打印
        int[] arr = ArrayUtils.createArray(200, 7 * 7 * 7 * 7);
        int[] temp = new int[arr.length];
        ArrayUtils.print(arr);
        // TODO: 2019/07/28 排序操作
//        bubble(arr);
//        select(arr);
//        insert(arr);
//        quick(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1, temp);
//        shell(arr);
        radix(arr);
        // TODO: 2019/07/28 打印验证
        System.out.println("==== 排序后 ====");
        ArrayUtils.print(arr);
    }

    private static void radix(int[] arr) {
        // READY 2019/07/28 准备桶，统计桶，最大位数，遍历索引
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];
        int max = arr[0], maxLength;
        int index;
        // TODO: 2019/07/28 遍历获取最大值
        for (int elem : arr) {
            if (max < elem) max = elem;
        }
        maxLength = (max + "").length();
        // TODO: 2019/07/28 放入，取出，释放
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // TIPS 2019/07/28 arr[]
            for (int elem : arr) {
                int dig = elem / n % 10;
                bucket[dig][bucketCount[dig]++] = elem;
            }
            index = 0;
            // TIPS 2019/07/28 bucket[][]
            for (int j = 0; j < bucketCount.length; j++) {
                if (bucketCount[j] != 0) {
                    for (int k = 0; k < bucketCount[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                // WARN !! 2019/07/28 清空
                bucketCount[j] = 0;
            }
        }
    }
    private static void shell(int[] arr) {
        // TODO: 2019/07/28 步长，向后，向前
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int start = gap; start < arr.length; start++) {
                for (int first = start - gap; first >= 0; first -= gap) {
                    if (arr[first + gap] < arr[first]) ArrayUtils.swap(arr, first + gap, first);
                }
            }
        }
    }
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // READY 2019/07/28 中间值
        int mid;
        // TODO: 2019/07/28 分解，递归，合并
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
       // READY 2019/07/28 数组开端
        int beginFirst = left, beginSecond = mid + 1, beginTemp = 0;
        // TODO: 2019/07/28 分别拷贝，剩余拷贝，拷贝还原
        while (beginFirst <= mid && beginSecond <= right) {
            if (arr[beginFirst] <= arr[beginSecond]) temp[beginTemp++] = arr[beginFirst++];
            else temp[beginTemp++] = arr[beginSecond++];
        }
        while (beginFirst <= mid) temp[beginTemp++] = arr[beginFirst++];
        while (beginSecond <= right) temp[beginTemp++] = arr[beginSecond++];

        int arrLeft = left;
        beginTemp = 0;
        while (arrLeft <= right) arr[arrLeft++] = temp[beginTemp++];
    }

    private static void quick(int[] arr, int left, int right) {
        // READY 2019/07/28 端点索引，中间值
        int start = left, end = right, pivot = arr[(left + right) / 2];
        // TODO: 2019/07/28 中间逼近
        while (start < end) {
            // TODO: 2019/07/28 两侧定位
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            // WARN !! 2019/07/28 定位完毕
            if (start >= end) break;
            // TODO: 2019/07/28 交换数值
            ArrayUtils.swap(arr, start, end);
            // TODO: 2019/07/28 完毕处理
            if (arr[start] == pivot) end--;
            if (arr[end] == pivot) start++;
        }
        // TIPS 2019/07/28 极端情况
        if (start == end) {
            start++;
            end--;
        }
        // TODO: 2019/07/28 左右递归
        if (left < end) quick(arr, left, end);
        if (right > start) quick(arr, start, right);
    }

    private static void insert(int[] arr) {
        // READY 2019/07/28 最小索引，最小数值
        int minIndex, minValue;
        // TODO: 2019/07/28 第二个开始
        for (int i = 1; i < arr.length; i++) {
            // WARN !! 2019/07/28 重置
            minIndex = i - 1;
            minValue = arr[i];
            // TODO: 2019/07/28 查找位置
            while (minIndex >= 0 && minValue < arr[minIndex]) {
                arr[minIndex + 1] = arr[minIndex--];
            }
            // TODO: 2019/07/28 找到位置
            arr[minIndex + 1] = minValue;
        }
    }

    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) ArrayUtils.swap(arr, j, j + 1);
            }
        }
    }

    private static void select(int[] arr) {
        // READY 2019/07/28 最小索引
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            // WARN !! 2019/07/28 重置
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            // TODO: 2019/07/28 是否改变
            if (minIndex != i) ArrayUtils.swap(arr, minIndex, i);
        }
    }
}
