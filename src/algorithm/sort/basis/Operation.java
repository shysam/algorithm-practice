package algorithm.sort.basis;

import java.util.Arrays;

public class Operation {

    /**
     * 交换数据
     *
     * @param i
     * @param j
     */
    protected static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 小于
     *
     * @param left
     * @param right
     * @return
     */
    protected static boolean less(int left, int right) {
        return left < right;
    }

    /**
     * 小于
     *
     * @param left
     * @param right
     * @return
     */
    protected static boolean less(int[] a, int left, int right) {
        return a[left] < a[right];
    }

    /**
     * 大于
     *
     * @param left
     * @param right
     * @return
     */
    protected static boolean greater(int left, int right) {
        return right > left;
    }

    /**
     * 是否已经排序
     *
     * @return
     */
    protected static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印全部
     */
    protected static void show(int[] a) {

        if (!isSorted(a)) {
            try {
                throw new Exception("没有正确排序");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        showOnly(a);
    }

    protected static void showOnly(int[] a) {
        System.out.println(Arrays.toString(a));
    }

}
