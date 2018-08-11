package datastructure.linkedlist.basis;

/**
 * 单链表
 * 链表的基础操作：添加、删除、反转、链表的串联
 */
public class LinkedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert("第一个", 1);
        list1.insert("第二个", 2);
        list1.insert("第三个", 3);
        list1.insert("第四个", 4);
        list1.insert("第五个", 5);

        LinkedList list2 = new LinkedList();
        list2.insert("oh1", 1);
        list2.insert("oh2", 2);
        list2.insert("oh3", 3);
        list2.insert("oh4", 4);
        list2.insert("oh5", 5);

        list1.connect(list2);

        list1.print();

    }

    private Node first;

    private Node last;

    public void connect(LinkedList otherList) {
        last.next = otherList.first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        Node x = first;
        while (x != null) {
            System.out.println(x);
            x = x.next;
        }
    }

    public void print(Node x) {
        while (x != null) {
            System.out.println(x);
            x = x.next;
        }
    }

    public void insert(String name, int data) {
        Node newNode = new Node(name, data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    /**
     * 一个指向新链表的最左端，便于下一个节点连接
     */
    public void reverse() {
        Node newFirst = null;
        Node head = first;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = newFirst;
            newFirst = head;
            head = next;
        }

        print(newFirst);

    }

//    public void reverse() {
//        Node head = first;
//        Node pre = null;
//        Node next;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//
//        while (pre != null) {
//            System.out.println(pre);
//            pre = pre.next;
//        }
//    }

    public void delete(String name) {
        if (name == null) {
            return;
        }
        if (isEmpty()) {
            return;
        }

        // 首部相等
        if (name.equals(first.name)) {
            Node next = first.next;
            first.next = null;
            first = next;
            return;
        }

        // 尾部相等
        if (name.equals(last.name)) {
            Node x = first;
            while (x.next != last) {
                x = x.next;
            }
            x.next = last.next;
            return;
        }

        // 删除中部
        Node x = first;
        Node previous = first;
        while (!name.equals(x.name)) {
            previous = x;
            x = x.next;
        }

        previous.next = x.next;
        x.next = null;
    }

    static class Node {

        String name;
        int data;
        Node next;

        public Node(String name, int data) {
            this.data = data;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
