package datastructure.linkedlist.basis;

/**
 * Created by Sam on 2018/8/11
 * 循环单链表
 * 1.链表大小
 * 2.尾部插入
 * 3.头部插入
 * 4.根据索引获取节点
 * 5.删除元素
 */
public class CircularList {

    public static void main(String[] args) {

        CircularList list = new CircularList();

        list.add("第0索引节点");
        list.add("第一索引节点");
        list.add("第二索引节点");
        list.add("第三索引节点");
        list.add("第四索引节点");

//        list.addFirst("哈哈");

        Node node = list.getNode(2);
//        Node node = list.getNode("哈哈");
        Node preNode = list.getPreNode(node);

        list.print();

    }

    private Node first;

    private Node last;

    private int size;

    public void print() {
        Node x = first;
        for (int i = 0; i < size && x != null; i++, x = x.next) {
            System.out.println(x.name);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 尾部插入
     *
     * @param name
     */
    public void add(String name) {
        Node node = new Node(name);
        if (last == null) {
            first = node;
            last = node;
            last.next = first;
        } else {
            last.next = node;
            node.next = first;
            last = node;
        }
        size++;
    }

    /**
     * 插入头部
     *
     * @param name
     */
    public void addFirst(String name) {
        Node node = new Node(name);
        if (first == null) {
            first = node;
            last = node;
            last.next = first;
        } else {
            node.next = first;
            last.next = node;
            first = node;
        }
        size++;
    }

    /**
     * 获取指定索引的节点
     *
     * @param index
     * @return
     */
    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            // TODO: 2018/8/11 异常
            System.out.println("异常");
            return null;
        }

        Node x = first;
        for (int i = 0; i < index + 1; i++) {
            x = x.next;
        }
        return x;
    }

    public Node getNode(String name) {
        Node x = first;
        for (int i = 0; i < size; i++) {
            if (name.equals(x.name)) {
                return x;
            }
            x = x.next;
        }
        return null;
    }

    /**
     * 删除
     *
     * @param name
     */
    public void delete(String name) {

        if (isEmpty()) {
            return;
        }

        if (name.equals(first.name)) {
            last.next = first.next;
            first = first.next;
            first.next = null;
        } else if (name.equals(last.name)) {
            Node preNode = getPreNode(last);
            preNode.next = last.next;
            last.next = null;
            last = preNode;
        } else {
            Node node = getNode(name);
            Node preNode = getPreNode(node);
            Node next = node.next;

            preNode.next = next;
            node.next = null;
        }

    }

    /**
     * 获取指定节点的前一个节点
     *
     * @return
     */
    public Node getPreNode(Node node) {
        Node pre = null;
        Node x = first;
        for (int i = 0; i < size && x != null; i++) {
            if (node.name.equals(x.name)) {
                break;
            }
            pre = x;
            x = x.next;
        }
        return pre;
    }

    class Node {

        String name;

        Node next;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
