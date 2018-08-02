package sort.basis.simple;

import sort.basis.Operation;

/**
 * 冒泡排序 - 稳定
 * <p>
 * 比较次数：(n-1)+(n-2)+...+2+1 = n(n-1)/2
 * <p>
 * 交换次数：
 * (1)、最好：0次
 * (2)、最坏：和比较次数一样 n(n-1)/2
 * <p>
 * 时间复杂度：
 * (1)、一般：O(n²)
 * (2)、最好(改进版)：O(n)
 * <p>
 * 空间复杂度：O(1)
 */
public class Bubble extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    /**
     * 冒泡普通版
     *
     * @param a
     */
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡改进版
     *
     * @param a
     */
    public static void sortOpt(int[] a) {
        int n = a.length;
        boolean didSwap;
        for (int i = 0; i < n - 1; i++) {
            didSwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                    didSwap = true;
                }
            }
            if (!didSwap) {
                return;
            }
        }
    }

}
