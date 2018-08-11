package datastructure.linkedlist;

/*

    环形链表插值练习

    问题：
    有一个整数value，如何在节点值有序的环形链表中插入一个节点值为value的节点，并且保证这个环形单链表依然有序。
    给定链表的信息，及元素的值a及对应的next指向的元素编号同时给定value，请构造出这个环形链表，并插入该值。
    测试样例：

    [1,3,4,5,7],[1,2,3,4,0],2

    返回：{1,2,3,4,5,7}

 */
public class P1 {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 7};
        int[] next = {1, 2, 3, 4, 0};
        int value = 2;
//        insert(a, next, value);
    }

//    /**
//     * 先构造环形链表，再插入
//     *
//     * @param a
//     * @param next
//     * @param value
//     * @return
//     */
//    public static ListNode insert(int[] a, int[] next, int value) {
//
//    }

    class ListNode {

        int value;

        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
