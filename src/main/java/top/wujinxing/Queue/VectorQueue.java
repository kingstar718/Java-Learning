package top.wujinxing.Queue;

import java.util.Vector;

/**
 * @author: wujinxing
 * @date: 2019/1/11 08:45
 * @description: 使用util包自带的vector来构建Queue
 * vector基于可扩展的动态数组来实现的，非循环数组
 */
public class VectorQueue<T> implements QueueInterface<T> {

    private Vector<T> queue;
    public VectorQueue(){
        queue = new Vector<T>();
    }
    public VectorQueue(int initialCapacity){
        queue = new Vector<T>(initialCapacity);
    }

    @Override
    public void enqueue(T newEntry) {
        queue.add(newEntry);
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()){
            front = queue.remove(0);
        }
        return front;
    }

    @Override
    public T getFront() {
        T front = null;
        if (!isEmpty()){
            front = queue.get(0);
        }
        return front;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
