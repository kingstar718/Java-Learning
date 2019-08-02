package top.wujinxing.ch_1_datastructure.list;

import java.util.Vector;

/**
 * @author: wujinxing
 * @date: 2019/1/11 15:41
 * @description:
 */
public class VectorList<T> implements ListInterface<T> {

    private Vector<T> list;

    public VectorList(){
        list = new Vector<T>();
    }
    public VectorList(int initialCapacity){
        list = new Vector<T>(initialCapacity);
    }

    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }

    @Override
    public boolean add(int newPositon, T newEntry) {
        boolean isSuccessful = true;
        if ((newPositon >= 0)&&(newPositon <= list.size() + 1)){
            list.add(newPositon - 1, newEntry);
        }else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if((givenPosition >= 0)&&(givenPosition <= list.size())){
            assert !isEmpty();
            result = list.remove(givenPosition);
        }
        return result;
    }

    @Override
    public void clear() {
        list.clear();
    }

    /**
     * 取代的是索引值，即从0开始
     * @param givenPosition
     * @param newEntry
     * @return
     */
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 0)&&(givenPosition <= list.size())){
            assert !isEmpty();
            list.set(givenPosition,newEntry);
        }else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0)&&(givenPosition <= list.size())){
            assert !isEmpty();
            result = list.get(givenPosition);
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) list.toArray();

        return result;
    }
}
