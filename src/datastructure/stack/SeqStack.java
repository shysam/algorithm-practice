package datastructure.stack;

import java.util.Arrays;

public class SeqStack<T> implements Stack<T> {

    public static void main(String[] args) {
        SeqStack<String> stack = new SeqStack<>();

        stack.push("哈哈哈");
        stack.push("哦");
        stack.push("121");
        stack.push("几十块地方");

        String pop = stack.pop();

        String peek = stack.peek();
        String peek1 = stack.peek();

        stack.print();

    }

    T[] array;

    int capacity = 10;

    // 大小
    int size = 0;

    public SeqStack() {
        array = (T[]) new Object[capacity];
    }

    public SeqStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T data) {
        if (size == array.length) {
            expandCapacity(2 * size + 1);
        }
        array[size] = data;
        size++;
    }

    private void expandCapacity(int capacity) {
        T[] old = array;
        array = (T[]) new Object[capacity];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        T t = array[size];
        array[size] = null;
        return t;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[size - 1];
    }

}
