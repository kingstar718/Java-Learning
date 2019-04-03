package top.wujinxing.List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: wujinxing
 * @date: 2019/3/14 14:47
 * @description:
 */
public class MyLinkedList<E> implements Iterator<E>{

    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    private static class Node<E>{
        public Node(E d,Node<E> p, Node<E> n){
            data = d;
            prev = p;
            next = n;
        }
        public E data;
        public Node<E> prev;
        public Node<E> next;
    }

    public MyLinkedList(){
        clear();
    }

    public void clear(){
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null,beginMarker,null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean add(E x){
        add(size(),x);
        return true;
    }

    public void add(int idx, E x){
        addBefore(getNode(idx), x);
    }
    public E get(int idx){
        return getNode(idx).data;
    }
    public E set(int idx, E newVal){
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public E remove(int idx){
        return remove(getNode(idx));
    }

    //p为指定的插入元素节点
    private void addBefore(Node<E> p, E x){
        //元素初始化为Node  p.prev是p的前一个节点
        //初始化时，已将prev指向了p.prev,next指向了p
        Node<E> newNode = new Node<>(x,p.prev,p);
        //初始化后，newNode.prev即是前一个节点，它的next指向新的节点
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private E remove(Node<E> p){
        //p的next即是下一个节点，它的prev需要指向p的上一个节点，即p.prev
        //p的prev即是上一个节点，它的next需要指向p的下一个节点，即p.next;
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }
    //遍历  从前往后  从后往前
    private Node<E> getNode(int idx){
        Node<E> p;

        if(idx<0 || idx >size()) throw new IndexOutOfBoundsException();

        if (idx < size()/2){
            p = beginMarker.next;
            for(int i = 0; i < idx; i++) p = p.next;
        }else {
            p = endMarker;
            for (int i = size(); i > idx; i--) p = p.prev;
        }
        return p;
    }



    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<E>{

        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }
        @Override
        public E next() {
            if (modCount != expectedModCount) throw new ConcurrentModificationException();
            if (!hasNext()) throw new NoSuchElementException();

            E nextItem = current.data;
            current = current.next; //指向下一个节点
            okToRemove = true;
            return nextItem;
        }

        public void remove(){
            if (modCount != expectedModCount) throw new ConcurrentModificationException();
            if (!okToRemove) throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
