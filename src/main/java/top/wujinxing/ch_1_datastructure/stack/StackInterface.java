package top.wujinxing.ch_1_datastructure.stack;

/**
 * @author: wujinxing
 * @date: 2019/1/9 10:50
 * @description:
 */
public interface StackInterface<T> {
    /**
     * Adds a new entry to the top of this stack
     * @param newEntry
     */
    public void push(T newEntry);

    /**
     * Removes and returns this stack's top entry
     * @return
     */
    public T pop();

    /**
     * Retrieves this stack's top entry
     * @return
     */
    public T peeK();

    /**
     * Detects whether this stack is empty
     * @return
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this stack
     */
    public void clear();
}
