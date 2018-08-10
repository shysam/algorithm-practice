package algorithm.sort.basis.simple;

import algorithm.sort.basis.Operation;

/**
 * Created by shysam on 2018/8/3
 * 选择排序 - 不稳定（例：55200，第一个5和第三个2交换，相对顺序发生变化）
 * <p>
 * 比较次数：
 * (1)、最好：n(n-1)/2
 * (2)、最坏：n(n-1)/2
 * (3)、平均：n(n-1)/2
 * <p>
 * 交换次数（固定，因为会跟自己交换）：
 * (1)、最好：n
 * (2)、最坏：n
 * (3)、平均：n
 * <p>
 * 时间复杂度：
 * (1)、最好：O(n²)
 * (2)、最坏：O(n²)
 * (3)、平均：O(n²)
 */
public class Selection extends Operation {

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
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

}
