package top.wujinxing.Stack;

import java.util.Vector;

/**
 * @author: wujinxing
 * @date: 2019/1/9 15:33
 * @description:使用Vector来构造Stack
 */
public class VectorStack<T> implements StackInterface<T> {

    private Vector<T> stack;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public VectorStack(int initialCapacity){
        stack = new Vector<T>(initialCapacity);
    }

    @Override
    public void push(T newEntry) {
        stack.add(newEntry);
    }

    @Override
    public T pop() {
        T top = null;
        if (!isEmpty()){
            top = stack.remove(stack.size() - 1);
        }
        return top;
    }

    @Override
    public T peeK() {
        T top = null;
        if (!isEmpty()){
            //返回向量中的最后一个元素
            top = stack.lastElement();
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void clear() {
        stack.clear();
    }
}
