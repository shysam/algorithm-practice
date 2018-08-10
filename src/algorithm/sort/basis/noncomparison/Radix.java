package algorithm.sort.basis.noncomparison;

import algorithm.sort.basis.Operation;

/**
 * Created by sam on 2018/8/4
 * 基数排序 -
 */
public class Radix extends Operation {

    public static void main(String[] args) {
        int[] a = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        sort(a, 3);
        show(a);
    }

    /**
     * @param number
     * @param d      表示最大的数有多少位
     */
    public static void sort(int[] number, int d) {
        int k = 0;
        int n = 1;
        int m = 1; // 控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {

            // 第一遍，按照个位数，将所有数放入桶中
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }

            // 重新排列给原数组
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }

}
