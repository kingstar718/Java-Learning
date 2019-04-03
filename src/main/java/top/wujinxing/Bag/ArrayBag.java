package top.wujinxing.Bag;

/**
 * @author: wujinxing
 * @date: 2019/1/3 13:35
 * @description: 不可变的数组大小的袋子
 */
public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    //默认的构造函数可以调用下面的构造函数，将默认的容量值作为实参传递给他
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }
    public ArrayBag(int capacity){
        numberOfEntries = 0;
        //抑制编译器产生未经检查的强制类型转换的警告
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }


    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * 删除特定索引的元素
     * @param givenIndex
     * @return
     */
    private T removeEntry(int givenIndex){
        T result = null;
        if(!isEmpty() && givenIndex > 0){
            result = bag[givenIndex];
            numberOfEntries--;
            bag[givenIndex] = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        }
        return result;
    }

    @Override
    public boolean add(T newEntry) {
        boolean result = true;
        //如果满了， 返回false
        if(isFull())
        {
            result = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    @Override
    public T remove() {
        /*T result = null;
        if(numberOfEntries > 0){
            numberOfEntries--;
            result = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        }*/
        //使用私有方法重写
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);  //返回的删除的元素
        return anEntry.equals(result);
    }

    /**
     * 清空
     */
    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    //统计一个给定对象在袋子中出现的次数
    @Override
    public int getFrequencyOf(T anEntry) {
        int countor = 0;
        for (int index = 0; index <numberOfEntries; index++){
            if(anEntry.equals(bag[index])){
                countor++;
            }
        }
        return countor;
    }

    /**
     * 检查袋子中是否有该元素
     * @param anEntry
     * @return
     */
    @Override
    public boolean contains(T anEntry) {
        /*boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++){
            if(anEntry.equals(bag[index])){
                found = true;
            }
        }*/
        //使用私有方法来重写
        return getIndexOf(anEntry) > -1;
    }

    //返回的是复制，不能是bag本身
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for(int index = 0; index <numberOfEntries; index++){
            result[index] = bag[index];
        }
        return result;
    }

    private int getIndexOf(T anEntry){
        int where = -1; //初始化为-1
        //使用布尔值来控制循环
        /*boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++){
            if (anEntry.equals(bag[index])){
                found = true; //如果找到了该值， 将布尔值改变，那么for循环将被打断
                where = index;
            }
        }*/
        //避免使用！操作符的方法
        boolean stillLooking = true;
        for (int index = 0; stillLooking && (index < numberOfEntries); index++){
            if (anEntry.equals(bag[index])){
                stillLooking = false; //如果找到了该值， 将布尔值改变，那么for循环将被打断
                where = index;
            }
        }
        return where;
    }
}
