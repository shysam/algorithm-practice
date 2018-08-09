package sort.practice;

import sort.basis.Operation;

/*

    Created by shysam on 2018/8/5

    荷兰国旗问题，三色排序

    问题：
    有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
    测试样例：
    [0,1,1,0,2,2],6
    返回：[0,0,1,1,2,2]

 */
public class P4 extends Operation {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 0, 2, 1, 1, 0};
        sort(a, a.length);
        show(a);
    }

    public static void sort(int[] a, int n) {
        int left = -1;
        int index = 0;
        int right = a.length;
        while (index < right) {
            if (a[index] == 0) {
                exch(a, ++left, index++);
            } else if (a[index] == 2) {
                exch(a, index, --right);
            } else {
                index++;
            }
        }
    }

}
