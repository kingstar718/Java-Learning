package top.wujinxing.Iterator;

import top.wujinxing.List.ListInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: wujinxing
 * @date: 2019/1/20 21:46
 * @description: 独立迭代器
 */
public class SeparateIterator<T> implements Iterator<T> {

    private ListInterface<T> list;
    private int nextPosition;
    private boolean wasNextCalled;

    public SeparateIterator(ListInterface<T> alist) {

        list = alist;
        nextPosition = 0;
        wasNextCalled = false;
    }

    @Override
    public boolean hasNext() {
        return nextPosition < list.getLength();
    }

    @Override
    public T next() {
        if (hasNext()){
            wasNextCalled = true;
            nextPosition++;
            return list.getEntry(nextPosition);
        }else {
            throw new NoSuchElementException("Illegal call to next(): " + "iterator is after and of list.");
        }
    }

    @Override
    public void remove() {
        if (wasNextCalled){
            list.remove(nextPosition);
            nextPosition--;

            wasNextCalled = false;
        }else {
            throw new IllegalStateException("Illegael call to remove();" + "next() was not called;");
        }

    }
}
