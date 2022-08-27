package top.wujinxing.tree;

import java.nio.BufferUnderflowException;

/**
 * @author: wujinxing
 * @date: 2019/3/14 17:31
 * @description: 二叉查找树
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private static class BinaryNode<E>{
        //Constructors
        BinaryNode(E theElement){
            this(theElement, null, null);
        }
        BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt){
            element = theElement;
            left = lt;
            right = rt;
        }

        E element;      //The data in the data
        BinaryNode<E> left;     //Left child
        BinaryNode<E> right;    //ringht child
    }

    private BinaryNode<E> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(E x){
        return contains(x, root);
    }

    public E findMin(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }
    //原书为UnderflowException
    public E findMax(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(E x){
        root = insert(x, root);
    }

    public void remove(E x){
        root = remove(x, root);
    }

    public void printTree(){

    }

    //private methods
    //Internal method to find an item in a subtree
    private boolean contains(E x, BinaryNode<E> t){
        if (t==null) return false;

        int compareResult = x.compareTo(t.element);
        //递归
        if (compareResult<0){
            return contains(x, t.left);
        }else if (compareResult>0){
            return contains(x, t.right);
        }else {
            return true; //匹配
        }

    }
    //返回包含树中包含最小元和最大元的节点的引用
    private BinaryNode<E> findMin(BinaryNode<E> t){
        if (t==null){
            return null;
        }else if (t.left == null){
            return t;
        }
        return findMin(t.left); //递归
    }
    private BinaryNode<E> findMax(BinaryNode<E> t){
        //非递归
        if (t!=null){
            while (t.right != null){
                t = t.right;
            }
        }
        return t;
    }
    //首次传入的是root = insert(x, root)
    //先和root的元素比较，小于root元素就和左子节点的元素比较，大就和右子节点的元素比较，递归
    private BinaryNode<E> insert(E x, BinaryNode<E> t){
        if (t==null){
            return new BinaryNode<>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult<0){
            t.left = insert(x, t.left);
        }else if (compareResult>0){
            t.right = insert(x ,t.right);
        }else {

        }
        return t;
    }

    private BinaryNode<E> remove(E x, BinaryNode<E> t){
        if(t==null) return t;
        int compareResult = x.compareTo(t.element);

        if (compareResult<0){
            t.left = remove(x, t.left);
        }else if (compareResult>0){
            t.right = remove(x, t.right);
        }else if (t.left != null && t.right !=null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    private void printTree(BinaryNode<E> t){

    }
}
