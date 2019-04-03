package top.wujinxing.Queue;

/**
 * @author: wujinxing
 * @date: 2019/1/10 16:06
 * @description:
 */
public interface QueueInterface<T> {
    /**
     * Adds a new entry to the back of the queue
     * @param newEntry
     */
    public void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of this queue
     * @return
     */
    public T dequeue();

    /**
     * Retrieves the entry at the front of this queue
     * @return
     */
    public T getFront();

    /**
     * Detects whether this queue is empty
     * @return
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this queue
     */
    public void clear();
}
