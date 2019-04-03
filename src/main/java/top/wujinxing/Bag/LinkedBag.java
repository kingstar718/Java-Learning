package top.wujinxing.Bag;

/**
 * @author: wujinxing
 * @date: 2019/1/7 11:01
 * @description:
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;     //节点链表的头引用
    private int numberOfEntries;    //记录当前袋子的物品数量，即是链表中节点的数量

    public LinkedBag(){
        firstNode = null;
        numberOfEntries = 0;
    }

    // 内部类
    private class Node{
        private T data;
        private Node next;  //引用整个另一个节点

        // 注意，两个构造函数
        private Node(T dataPortion){
            this(dataPortion,null);
        }

        private Node(T dataPortion, Node nextNode){
            data = dataPortion;
            next = nextNode;
        }
        public T getData() {
            return data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public Node getNextNode() {
            return next;
        }
        public void setNextNode(Node next) {
            this.next = next;
        }
    }
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (numberOfEntries == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        //make new node reference rest of chain,(firstNode is null if chain is empty)
        //newNode.next = firstNode;
        newNode.setNextNode(firstNode);

        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if(firstNode != null){
            //result = firstNode.data;
            result = firstNode.getData();
            //remove first node from chain 为什么这句就可以删除firstNode
            //首先firstNode.next代表的就是整个第二个节点，该句只是让第二个节点对象赋给firstNode
            //firstNode = firstNode.next;
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null){
            //nodeN.data = firstNode.data;
            nodeN.setData(firstNode.getData());

            remove();
            result = true;
        }
        return result;
    }

    // 根据实体找链表的节点对象
    private Node getReferenceTo(T anEntry){
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)){
            if (anEntry.equals(currentNode.data)){
                found = true;
            }else {
                //currentNode = currentNode.next;
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;

        int counter = 0;
        Node currentNode = firstNode;
        while ((counter < numberOfEntries) && (currentNode !=null)){
            if (anEntry.equals(currentNode.data)){
                frequency++;
            }
            counter++;
            //前进到下一个节点
            //currentNode = currentNode.next;
            currentNode = currentNode.getNextNode();

        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)){
            if(anEntry.equals(currentNode.data)){
                found = true;
            }else {
                //currentNode = currentNode.next; // 将currentNode移动到第二个节点上 因为firstNode已经等于currentNode
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unckecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.data;
            index++;
            //currentNode = currentNode.next;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }


}
