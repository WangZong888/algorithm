package com.nogizaka.basic;

public class HanoiTower {
    public static void main(String[] args) {
        // TEST
        hanoi(3, 'a', 'b', 'c');
    }

    /**
     * 汉诺塔问题
     * @param num 盘子个数
     * @param start 开始位置
     * @param mid 辅助位置
     * @param end 最终位置
     */
    private static void hanoi(int num, char start, char mid, char end) {
        // TODO: 2019/07/28 num = 1
        if (num == 1) System.out.printf("no.1 : %c -> %c\n", start, end);
        // TODO: 2019/07/28 num > 1
        else {
            // TODO: 2019/07/28 num - 1 : a -> b
            hanoi(num - 1, start, end, mid);
            // TODO: 2019/07/28 num : a -> c
            System.out.printf("no.%d : %c -> %c\n", num, start, end);
            // TODO: 2019/07/28 num - 1 : b -> c
            hanoi(num - 1, mid, start, end);
        }
    }
}
