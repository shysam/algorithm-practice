package sort.basis.simple;

import sort.basis.Operation;

/**
 * 希尔排序 - 不稳定
 * <p>
 * 比较次数：未知
 * 交换次数：未知
 * <p>
 * 时间复杂度：
 * (1)、最好：O(n)
 * (2)、最坏：O(n²)
 * (3)、平均：O(n1.3次幂)
 * <p>
 * 空间复杂度：O(1)
 */
public class Shell extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    /**
     * @param a
     */
    public static void sort(int[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

}
