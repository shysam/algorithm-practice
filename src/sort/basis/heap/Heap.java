package sort.basis.heap;

import sort.basis.Operation;

/**
 * 堆排 - 不稳定
 */
public class Heap extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    public static void sort(int[] pq) {
        int n = pq.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(int[] pq, int i, int j) {
        return pq[i - 1] < pq[j - 1];
    }

    public static void exch(int[] pq, int i, int j) {
        int temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }

}
