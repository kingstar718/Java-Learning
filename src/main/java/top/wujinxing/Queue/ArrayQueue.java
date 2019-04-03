package top.wujinxing.Queue;

/**
 * @author: wujinxing
 * @date: 2019/1/10 21:54
 * @description:
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;

    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayQueue(){
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int initialCapacity){
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity+1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
    }

    private void ensureCapacity(){
        if (frontIndex == (backIndex + 2) % queue.length){
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[2*oldSize];
            queue = tempQueue;
            for (int index=0; index<oldSize-1; index++){
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }
            frontIndex = 0;
            backIndex = oldSize - 2;
        }
    }

    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()){
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()){
            front = queue[frontIndex];
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex == ((backIndex + 1) % queue.length);
    }

    @Override
    public void clear() {

    }



}
