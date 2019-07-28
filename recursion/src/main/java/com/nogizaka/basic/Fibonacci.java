package com.nogizaka.basic;

public class Fibonacci {
    public static void main(String[] args) {
        // test - 1 1 2 3 5 8 13 21 34 55
        System.out.println(fibonacci(10));
    }

    private static int fibonacci(int num) {
        // TODO: 2019/07/28 num == 1 or 2
        if (num == 1 || num == 2) return 1;
        // TODO: 2019/07/28 num > 2
        else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}
