package sort.basis.heap;

import sort.basis.Operation;

/**
 * Created by shysam on 2018/8/2
 * 堆排 - 不稳定
 * <p>
 * 比较次数：少于 2nlogn+2n （2n来自构造，2nlogn来自每次下沉操作最大可能需要2logn）
 * <p>
 * 交换次数：比较次数的一半
 * <p>
 * 时间复杂度：O(nlogn)
 * <p>
 * 空间复杂度：O(1)
 */
public class Heap extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    public static void sort(int[] pq) {
        int n = pq.length;

        // 有序化
        // 最坏情况下比较次数：2N
        // 最坏情况下交换次数：N
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // 取出第一个最大值，放到数组末尾，再有序化得到最大值
        // 树的的顶部到底部的路径大小logN，因为要和兄弟节点做比较，所以总比较次数2logN，进行n轮，
        // 比较次数为 2nlogn，
        // 交换次数 n + nlogn
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    /**
     * 下沉
     *
     * @param pq
     * @param k
     * @param n
     */
    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            // j<n 说明右子树有值，右子树大的话，j指向右子树
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
