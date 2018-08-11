package datastructure.linkedlist.practice;

/*

    环形链表（LeetCode-141、https://leetcode-cn.com/problems/linked-list-cycle/solution/）

    问题：
    给定一个链表，判断链表中是否有环。

    进阶：
    你能否不使用额外空间解决此题？

 */
public class P1 {

//    /**
//     * 方法1：哈希表
//     *
//     * @param head
//     * @return
//     */
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    /**
     * 方法二：双指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
