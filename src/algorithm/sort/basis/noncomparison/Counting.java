package algorithm.sort.basis.noncomparison;

import algorithm.sort.basis.Operation;

/**
 * 计数排序 - 稳定，线性时间
 */
public class Counting extends Operation {

    public static void main(String[] argv) {
        int[] a = new int[]{5, 4, 7, 1, 8};

        // 方案1
        int[] result = sort(a);

        // 方案2
        int[] resultOpt = sortOpt(a);

        show(result);
        show(resultOpt);
    }

    // ====================================================================================================

    /**
     * 针对C数组优化
     *
     * @param a
     * @return
     */
    public static int[] sortOpt(int[] a) {
        int b[] = new int[a.length];
        int max = a[0];
        int min = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        // 这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;// 优化过的地方，减小了数组c的大小
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i] - min]] = a[i];// 按存取的方式取出c的元素
        }
        return b;
    }

    // ====================================================================================================

    /**
     * 方案1：没有针对C数组的优化
     *
     * @param a
     * @return
     */
    public static int[] sort(int[] a) {
        int[] result = new int[a.length];
        // 假设A中的数据a'有，0<=a' && a' < k并且k=100
        int k = 100;
        sort(a, result, k);
        return result;
    }

    private static void sort(int[] array, int[] result, int k) {
        int[] C = new int[k];
        int n = array.length;

        // 计数
        for (int j = 0; j < n; j++) {
            int a = array[j];
            C[a] += 1;
        }

        // 求计数和
        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // 整理
        for (int j = n - 1; j >= 0; j--) {
            int a = array[j];
            result[C[a] - 1] = a;
            C[a] -= 1;
        }
    }

    // ====================================================================================================

}
