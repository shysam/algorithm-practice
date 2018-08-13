package datastructure.queue;

public class SeqQueue<T> implements Queue<T> {

    private T[] array;

    private int size;

    public SeqQueue() {
        array = (T[]) new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T data) {
        array[size] = data;
        return true;
    }

    @Override
    public boolean offer(T e) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return array[0];
    }
}
