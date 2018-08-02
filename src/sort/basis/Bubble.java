package sort.basis;

import sort.basis.common.Operation;

/**
 * 冒泡排序
 */
public class Bubble extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    /**
     * 冒泡普通版
     * <p>
     * 比较次数：(n-1)+(n-2)+...+2+1 = n(n-1)/2
     * <p>
     * 交换次数：最少0次，最多和比较次数一样 n(n-1)/2
     * <p>
     * 时间复杂度：O(n²)
     * <p>
     * 空间复杂度：O(1)
     *
     * @param a
     */
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡改进版
     * <p>
     * 时间复杂度（最好的情况，已经排好）：O(n)
     *
     * @param a
     */
    public static void sortOpt(int[] a) {
        int N = a.length;
        boolean didSwap;
        for (int i = 0; i < N - 1; i++) {
            didSwap = false;
            for (int j = 0; j < N - i - 1; j++) {
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
