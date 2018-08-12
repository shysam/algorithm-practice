package algorithm.sort.basis.quick;

import algorithm.sort.basis.Operation;

/**
 * Created by shysam on 20q18/8/2
 * 快速排序 - 不稳定
 * 时间复杂度：
 * (1)、最好：nlogn
 * (2)、最坏：n(n-1)/2
 * (3)、平均：nlogn
 */
public class Quick extends Operation {

    public static void main(String[] args) {
//        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
//        int[] a = {10, 1, 2, 3, 4, 5}; // 触发 i == hi
//        int[] a = {10, 11, 12, 13, 14, 15}; // 触发 j == lo
//        int[] a = {10, 1, 2, 3, 10, 15, 16, 17}; // i和j相等
        int[] a = {};
        sort(a);
        show(a);
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    /**
     * 找切分点，交换
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }      // redundant since a[lo] acts as sentinel
            }

            // i==j 情况如下
            // 1.数组为顺序或逆序
            // 2.刚好i和j前进一步到汇合

            // i>j 情况如下
            // j的右边 j>=v
            // 由i<=v得到 j<=v
            // j的右边 j>=v ，j的左边 j<=v。结论是 j可以作为切分点
            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

}
