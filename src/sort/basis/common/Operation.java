package sort.basis.common;

public class Operation {

    /**
     * 交换数据
     *
     * @param i
     * @param j
     */
    public static void exch(int[] a, int i, int j) {
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
    public static boolean less(int left, int right) {
        return left < right;
    }

    /**
     * 大于
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean greater(int left, int right) {
        return right > left;
    }

    /**
     * 是否已经排序
     *
     * @return
     */
    public static boolean isSorted(int[] a) {
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
    public static void show(int[] a) {

        if (!isSorted(a)) {
            try {
                throw new Exception("没有正确排序");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
