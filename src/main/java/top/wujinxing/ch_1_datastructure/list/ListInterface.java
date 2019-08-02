package top.wujinxing.ch_1_datastructure.list;

/**
 * @author: wujinxing
 * @date: 2019/1/11 09:16
 * @description:
 */
public interface ListInterface<T> {
    /**
     * Adds a new entry to the end of this list
     * @param newEntry
     */
    public void add(T newEntry);

    /**
     * Adds a new entry at a specified position within this list
     * @param newPositon
     * @param newEntry
     * @return
     */
    public boolean add(int newPositon, T newEntry);

    /**
     * Removes the entry at a given position from this list
     * @param givenPosition
     * @return
     */
    public T remove(int givenPosition);

    /**
     * Removes all entries from this list
     */
    public void clear();

    /**
     * Repalces the entry at a given position in this list
     * @param givenPosition
     * @param newEntry
     * @return
     */
    public boolean replace(int givenPosition, T newEntry);

    /**
     * Retrieves the entry at a given position in this list
     * @param givenPosition
     * @return
     */
    public T getEntry(int givenPosition);

    /**
     * Sees whether this lsit co
     * @param anEntry
     * @return
     */
    public boolean contains(T anEntry);

    public int getLength();

    public boolean isEmpty();

    public T[] toArray();
}
