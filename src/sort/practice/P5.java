package sort.practice;

import sort.basis.Operation;

/*

    Created by shysam on 2018/8/9

    有序数组合并

    问题：
    有两个从小到大排序以后的数组A和B，其中A的末端有足够的缓冲空容纳B。请编写一个方法，将B合并入A并排序。
    给定两个有序int数组A和B，A中的缓冲空用0填充，同时给定A和B的真实大小int n和int m，请返回合并后的数组。

 */
public class P5 extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 12, 36, 88, 102, 200, 0, 0, 0, 0, 0, 0};
        int[] b = new int[]{2, 6, 18, 35, 65, 99};
        int[] c = mergeAB(a, b, 7, b.length);
        show(c);
    }

    /**
     * 比较末位，类似归并
     *
     * @param A
     * @param B
     * @param n
     * @param m
     * @return
     */
    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
        while (m != 0) {
            if (n == 0) {
                A[m - 1] = B[m - 1];
                m--;
            } else {
                A[m + n - 1] = A[n - 1] > B[m - 1] ? A[--n] : B[--m];
            }
        }
        return A;
    }

//    public static int[] mergeAB(int[] A, int[] B, int n, int m) {
//        int i = n - 1;
//        int j = m - 1;
//        int k = m + n - 1;
//        while (i >= 0 && j >= 0) {
//            if (A[i] > B[j]) {
//                A[k] = A[i];
//                i--;
//            } else {
//                A[k] = B[j];
//                j--;
//            }
//            k--;
//        }
//        while (j >= 0) {
//            A[j] = B[j];
//            j--;
//        }
//        return A;
//    }

//    /**
//     * 简单版的，需创建多一个数组
//     *
//     * @param a
//     * @param b
//     * @param n
//     * @param m
//     * @return
//     */
//    private static int[] mergeAB(int[] a, int[] b, int n, int m) {
//        int[] c = new int[a.length + b.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (i < a.length && j < b.length) {
//            if (a[i] <= b[j]) {
//                c[k++] = a[i++];
//            } else {
//                c[k++] = b[j++];
//            }
//        }
//        while (i < a.length) {
//            c[k++] = a[i++];
//        }
//        while (j < b.length) {
//            c[k++] = b[j++];
//        }
//        return c;
//    }

}
