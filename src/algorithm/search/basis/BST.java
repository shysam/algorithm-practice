package algorithm.search.basis;

import java.util.NoSuchElementException;

/**
 * 二叉查找树
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

    public static void main(String[] args) {

        BST<Integer, Integer> bst = new BST<>();
        bst.put(10, 10);
        bst.put(6, 6);
        bst.put(12, 12);
        bst.put(3, 3);
        bst.put(8, 8);
        bst.put(1, 1);
        bst.put(5, 5);
        bst.put(7, 7);
        bst.put(9, 9);
        bst.put(11, 11);
        bst.put(20, 20);

        bst.delete(6);
        System.out.println("");
    }

    private Node root;

    private class Node {

        // sorted by key
        private Key key;

        // associated data
        private Value value;

        // left subtrees
        private Node left;

        // right subtrees
        private Node right;

        // number of nodes in subtree
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        @Override
        public String toString() {
            return "节点" + key;
        }
    }

    /**
     * 树的大小
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    /**
     * 求节点大小
     *
     * @param x
     * @return
     */
    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 获取值
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 获取指定节点下的值
     *
     * @param x
     * @param key
     * @return
     */
    public Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return get(x.left, key);
        } else if (compare > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    /**
     * 新增节点
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    /**
     * 新增节点
     *
     * @param x
     * @param key
     * @param value
     */
    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = put(x.left, key, value);
        } else if (compare > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除key节点
     *
     * @param key
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls delete() with a null key");
        }
        root = delete(root, key);
    }

    /**
     * 删除指定节点的key
     *
     * @param x
     * @param key
     */
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        } else if (compare > 0) {
            x.right = delete(x.right, key);
        } else {
            // 只有左子树，左子树成为当前节点
            if (x.right == null) {
                return x.left;
            }
            // 只有右子树，右子树成为当前节点
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 最小的键
     *
     * @return
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    public Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return x.left;
        }
    }

    /**
     * 最大键
     *
     * @return
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    /**
     * 小于指定键的最大键
     *
     * @param key
     * @return
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    /**
     * 向下取整
     *
     * @param x
     * @param key
     * @return
     */
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if (compare == 0) {
            return x;
        } else if (compare < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    /**
     * 向上取整
     *
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }

    /**
     * 查找排名第k的键
     *
     * @param k
     * @return
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k.
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    /**
     * 返回给定键的排名
     *
     * @param key
     * @return
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    /**
     * 删除最小值
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除最大值
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

}
