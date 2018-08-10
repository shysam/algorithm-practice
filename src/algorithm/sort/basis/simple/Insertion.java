package algorithm.sort.basis.simple;

import algorithm.sort.basis.Operation;

/**
 * Created by shysam on 2018/8/3
 * 插入排序 - 稳定
 * <p>
 * 比较次数：
 * (1)、最好：n-1
 * (2)、最坏：n(n-1)/2
 * (3)、平均：n(n-1)/4
 * <p>
 * 交换次数：
 * (1)、最好：0
 * (2)、最坏：n(n-1)/2
 * (3)、平均：n(n-1)/2
 * <p>
 * 时间复杂度：
 * (1)、最好：O(n)
 * (2)、最坏：O(n²)
 * (3)、平均：O(n²)
 * <p>
 * 空间复杂度：O(1)
 */
public class Insertion extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{23, 42, 12, 65, 7, 34, 98, 5, 34, 23, 657, 78, 34, 56};
        sort(a);
        show(a);
    }

    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

}
