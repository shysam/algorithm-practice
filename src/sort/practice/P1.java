package sort.practice;

import sort.basis.Operation;

/*
    Created by shysam on 2018/8/2

    小范围排序问题

    问题：
    已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。
    请选择一个合适的排序算法针对这个数据进行排序。给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。

    测试样例：
    [2,1,4,3,6,5,8,7,10,9],10,2
    返回：[1,2,3,4,5,6,7,8,9,10]




    Result：
    (1)、使用插入排序
         时间复杂度：(n-1)*k

    (2)、使用改的堆排：nLogk
 */
public class P1 extends Operation {

    public static void main(String[] args) {

        int[] a = new int[]{3, 4, 1, 2, 5, 7, 6, 8};
        int n = a.length;
        int k = 2;

        sort(a, n, k + 1);

        show(a);
    }

    /**
     * 小范围排序
     *
     * @param a
     * @param n 数组大小
     * @param k 建立的堆的大小 k+1，因为k+1一定能找到最小的值
     */
    private static void sort(int[] a, int n, int k) {

        // 建立一个k+1的堆
        // 时间复杂度：k
        int[] aux = new int[k];
        for (int i = 0; i < k; i++) {
            aux[i] = a[i];
        }

        // 有序化，i指要下沉的点
        // 时间复杂度：k/2*logk
        for (int i = k / 2; i >= 1; i--) {
            sink(aux, i, k);
        }

        // 将已排序好的顶点放入原数组，取下一个数放入顶点，并做下沉操作
        // n-k是防止越界，如果循环走到倒数第三个值，那么取下一个数就是 倒数第三+3，已越界。所以排到只剩三个数就行
        // 时间复杂度：(n-k)*logk
        for (int i = 0; i < n - k; i++) {
            a[i] = aux[0];
            aux[0] = a[i + k];
            sink(aux, 1, k);
        }

        // 接着排剩下的K个，这K个数已经是堆有序
        // 时间复杂度：k*logk
        for (int i = n - k; i < n; i++) {
            a[i] = aux[0];
            exch(aux, 1, k);
            k--;
            sink(aux, 1, k);
        }

        // 总的时间复杂度：k + k/2*logk + (n-k)*logk + k*logk ≈ nlogk

    }

    /**
     * 下沉指定点，小顶堆
     *
     * @param pq
     * @param k
     * @param n
     */
    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j + 1, j)) {
                j++;
            }
            if (!less(pq, j, k)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    /**
     * 按1开始
     *
     * @param pq
     * @param i
     * @param j
     * @return
     */
    private static boolean less(int[] pq, int i, int j) {
        return pq[i - 1] < pq[j - 1];
    }

    /**
     * 交换按1开始
     *
     * @param pq
     * @param i
     * @param j
     */
    public static void exch(int[] pq, int i, int j) {
        int temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }


}
