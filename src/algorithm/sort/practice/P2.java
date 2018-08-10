package algorithm.sort.practice;

import algorithm.sort.basis.Operation;
import algorithm.sort.basis.heap.Heap;

/*

    Created by shysam on 2018/8/3

    重复值判断问题

    问题：
    请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
    给定一个int数组A及它的大小n，请返回它是否有重复值。
    测试样例：
    [1,2,3,4,5,5,6],7
    返回：true

 */
public class P2 extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3, 2, 5, 7, 6, 8};
        int n = a.length;
        boolean repeated = check(a, n);
        System.out.println("是否重复：" + repeated);
    }

    /**
     * 先堆排，再相邻比较
     * 时间复杂度：nlogn
     *
     * @param a
     * @param n
     * @return
     */
    private static boolean check(int[] a, int n) {
        // 时间复杂度：nlogn
        Heap.sort(a);

        //时间复杂度：n
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                return true;
            }
        }
        return false;
    }

//    /**
//     * 直接双层循环
//     * 时间复杂度：O(n²)
//     * 控件复杂度：O(1)
//     *
//     * @param a
//     * @param n
//     * @return
//     */
//    private static boolean check(int[] a, int n) {
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (a[i] == a[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}
