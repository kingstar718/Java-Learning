package top.wujinxing.Stack;

/**
 * @author: wujinxing
 * @date: 2019/1/9 11:09
 * @description:链表实现栈
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode; //references the first node in the chain

    private class Node{
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
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
    public void push(T newEntry) {
        //先分配一个新的节点，将其引用栈现有的链表
        Node newNode = new Node(newEntry,topNode);
        topNode = newNode;
    }

    @Override
    public T pop() {
        T top = peeK();
        if (topNode != null){
            //指向下一个节点
            topNode = topNode.getNextNode();
        }
        return top;
    }

    @Override
    public T peeK() {
        T top = null;
        if (topNode != null){
            top = topNode.getData();
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
    }
}
