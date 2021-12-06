package top.wujinxing.ch_5_questions.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2021-12-06
 */
public class Ch_2_LRU {

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    public Ch_2_LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            // 如果key不存在，创建一个新的节点
            DLinkNode newNode = new DLinkNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量则删除链表的尾部
                DLinkNode tail = remoteTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            //  如果key存在，则先通过哈希表定位再修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode remoteTail() {
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }


    static class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode() {
        }

        public DLinkNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
