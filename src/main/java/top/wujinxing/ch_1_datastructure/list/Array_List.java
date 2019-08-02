package top.wujinxing.ch_1_datastructure.list;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/1/11 11:17
 * @description:
 */
public class Array_List<T> implements ListInterface<T>{

    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public Array_List(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    public Array_List(int initialCapacity){
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity];
        list = tempList;
    }

    @Override
    public void add(T newEntry) {
        ensureCapacity();
        list[numberOfEntries] = newEntry;
        numberOfEntries++;
    }

    @Override
    public boolean add(int newPositon, T newEntry) {
        boolean isSuccessful = true;
        if ((newPositon >= 0) && (newPositon <= numberOfEntries + 1)){
            ensureCapacity();   //先判断数组是否够用
            makeRoom(newPositon);   //挪出newPosition位置
            //list[newPositon-1] = newEntry; 原版这样写，还是直接当做索引来用
            list[newPositon] = newEntry;
            numberOfEntries++;
        }else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0)&&(givenPosition <= numberOfEntries)){
            assert !isEmpty();
            result = list[givenPosition];
            if (givenPosition < numberOfEntries){
                removeGap(givenPosition);
            }
            numberOfEntries--;

        }
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 0)&&(givenPosition <= numberOfEntries)){
            assert !isEmpty();
            list[givenPosition] = newEntry;
        }else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0)&&(givenPosition <= numberOfEntries)){
            assert !isEmpty();
            //result = list[givenPosition - 1]; 原版这样写，感觉还是直接使用索引值比较好，与ArrayList相同
            result = list[givenPosition];
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++){
            if (anEntry.equals(list[index])){
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++){
            result[index] = list[index];
        }
        return result;
    }

    /**
     * 数组的扩容
     */
    private void ensureCapacity(){
        if (numberOfEntries == list.length){
            list = Arrays.copyOf(list, 2*list.length);
        }
    }

    private void makeRoom(int newPosition){
        //断言关键字     true继续执行，false返回AssertionError
        assert (newPosition >= 0) && (newPosition <= newPosition + 1);
        int newIndex = newPosition + 1;
        int lastIndex = numberOfEntries - 1;
        //为了在给定处添加数据，将之后的元素向后挪一位，注意，是从末尾开始，逆向进行
        for (int index = lastIndex; index >= newIndex; index--){
            list[index+1] = list[index];
        }
    }

    /**
     * 删除指定位置的元素，将后面的元素都向前移动一位
     * @param givenPosition
     */
    private void removeGap(int givenPosition){
        assert ((givenPosition >=0)&&(givenPosition < numberOfEntries));
        int removeIndex = givenPosition;
        int lastIndex = numberOfEntries - 1;
        for (int index = removeIndex; index < lastIndex; index++){
            list[index] = list[index + 1];      //将指定元素前移一位
        }
    }
}
