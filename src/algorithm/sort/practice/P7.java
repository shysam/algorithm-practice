package algorithm.sort.practice;

import algorithm.sort.basis.Operation;

/*

    Created by shysam on 2018/8/13

    对链表进行插入排序（LeetCode-147：https://leetcode-cn.com/problems/insertion-sort-list/description/）

    问题：
    从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 */
public class P7 extends Operation {

    public static void main(String[] args) {

        ListNode first = new ListNode(4);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(1);
        ListNode four = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = four;

        ListNode listNode = insertionSortList(first);

        print(listNode);
    }

    public static void print(ListNode head) {
        ListNode x = head;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 用一个辅助节点指向头节点
        ListNode dummyHead = new ListNode(0);
        ListNode p = head;
        dummyHead.next = head;
        while (p.next != null) {
            // 下一节点比前一节点大，已排序，跳到下一个
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                // 将未排序的第一个节点剥离出来，然后从左到右找到第一个比自己大的节点，插入到它前面
                ListNode temp = p.next;
                ListNode q = dummyHead;
                p.next = p.next.next;
                while (q.next.val < temp.val) {//找到第一个大于该节点的前一节点
                    q = q.next;
                }
                temp.next = q.next;  //将 temp 节点插入
                q.next = temp;
            }
        }
        return dummyHead.next;
    }

    public static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}
