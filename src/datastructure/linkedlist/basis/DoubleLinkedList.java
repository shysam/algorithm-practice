package datastructure.linkedlist.basis;

/**
 * Created by Sam on 2018/8/11
 * 双链表，非循环
 */
public class DoubleLinkedList {

    private Node head;

    private Node tail;

    private int size;

    /**
     * 指定位置插入
     *
     * @param index
     * @param name
     */
    public void add(int index, String name) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("错");
        }

        // 找到要插入的索引点
        Node nodeByIndex = getNodeByIndex(index);
        Node pre = nodeByIndex.pre;

        Node node = new Node(name, pre, nodeByIndex);

        pre.next = node;
        nodeByIndex.pre = node;

    }

    /**
     * @param index
     */
    public void delete(int index) {
        if (index < 0 || index >= size || isEmpty()) {
            return;
        }

        Node x = head;

        Node deleteNode = getNodeByIndex(index);

        Node pre = deleteNode.pre;
        Node next = deleteNode.next;

        if (pre != null) {
            pre.next = next;
        }

        if (next != null) {
            next.pre = pre;
        }

        deleteNode.next = null;
        deleteNode.pre = null;
    }

    public Node getNodeByIndex(int index) {
        Node x = head;
        for (int i = 1; i < index + 1; i++) {
            x = x.next;
        }
        return x;
    }

    /**
     * 尾部添加
     *
     * @param name
     */
    public void add(String name) {
        Node node = new Node(name, tail, null);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    class Node {

        String name;

        Node pre;

        Node next;

        public Node(String name, Node pre, Node next) {
            this.name = name;
            this.pre = pre;
            this.next = next;
        }
    }

}
