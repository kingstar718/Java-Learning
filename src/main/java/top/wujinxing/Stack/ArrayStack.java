package top.wujinxing.Stack;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/1/9 15:04
 * @description: a class of stacks whose entries are sorted in an array
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;  //array of stack entries
    private int topIndex;   //index of top entries
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayStack(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayStack(int initialCapacity){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    private void ensureCapacity(){
        if (topIndex == stack.length - 1){
            stack = Arrays.copyOf(stack,2*stack.length);
        }
    }

    @Override
    public void push(T newEntry) {
        ensureCapacity();
        topIndex++;
        stack[topIndex] = newEntry;
    }

    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()){
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        }
        return top;
    }

    @Override
    public T peeK() {
        T top = null;
        if (!isEmpty()){
            top = stack[topIndex];
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        topIndex = -1;
    }
}
