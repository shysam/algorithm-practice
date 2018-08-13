package datastructure.stack;

public interface Stack<T> {

    /**
     * 是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     */
    void push(T data);

    /**
     * 出栈
     *
     * @return
     */
    T pop();

    /**
     * 返回栈顶元素
     *
     * @return
     */
    T peek();

}
