package com.nogizaka.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
    public static void main(String[] args) {

    }

    /**
     * 创建数组，根据个数及边界
     *
     * @param num      个数
     * @param boundary 边界（随机数字）
     * @return 数组
     */
    public static int[] createArray(int num, int boundary) {
        // READY 2019/07/28 随机数字
        Random random = new Random();

        // TODO: 2019/07/28 1- 创建数组
        int[] arr = new int[num];
        // TODO: 2019/07/28 2- 遍历赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(boundary);
        }
        // TODO: 2019/07/28 3- 返回数组
        return arr;
    }

    /**
     * 打印数组元素
     *
     * @param arr 数组
     */
    public static void print(int[] arr) {
        // TODO: 2019/07/28 工具类（Arrays）
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组元素
     *
     * @param arr    数组
     * @param index1 索引1
     * @param index2 索引2
     */
    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] ^ arr[index2];
        arr[index2] = arr[index1] ^ arr[index2];
        arr[index1] = arr[index1] ^ arr[index2];
    }
}
