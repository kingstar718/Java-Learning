package top.wujinxing.ch_1_datastructure.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/1/11 11:34
 * @description:
 */
public class Test {

    @org.junit.Test
    public void ArrayListTest(){
        ListInterface<Integer> list = new Array_List<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(23);
        list.add(22);
        list.add(5,33);
        list.remove(2);
        list.remove(3);
        list.clear();
        System.out.println(list.getLength());
        for (int i = 0; i < list.getLength(); i++){
            System.out.print(list.getEntry(i)+" ");
        }
        System.out.println(list.contains(3));
        System.out.println(list.isEmpty());
        System.out.println();

        List<Integer> list1 =  new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(23);
        list1.add(22);
        list1.add(1,44);
        for (int i: list1
             ) {
            System.out.print(i + " ");
        }
    }

    @org.junit.Test
    public void VectorListTest(){
        ListInterface<Integer> list = new Array_List<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(23);
        list.add(22);
        /*

        list.remove(3);
        list.clear();
        System.out.println(list.getLength());
        */
        //list.add(2,33);
        list.replace(2,55);
        //list.remove(0);
        for (int i = 0; i < list.getLength(); i++){
            System.out.print(list.getEntry(i)+" ");
        }
        System.out.println();
        /*
        System.out.println(list.contains(3));
        System.out.println(list.isEmpty());
        */
        System.out.println(list.toArray());

    }

    public class Node{
        private int i;
        private Node next;

        public Node(int i, Node next) {
            this.i = i;
            this.next = next;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @org.junit.Test
    public void test(){
        Node firstNode = new Node(2,null);
        Node newNode = new Node(3,null);
        System.out.println("newNode.next: "+newNode.getNext());
        System.out.println("newNode.i: "+newNode.getI());
        newNode.setNext(firstNode);
        System.out.println("------------------");
        System.out.println("newNode.next: "+newNode.getNext());
        System.out.println("newNode.i: "+newNode.getI());
        firstNode = newNode;//将firstNode指向了newNode的对象
        System.out.println("------------------");
        System.out.println("newNode.next: "+newNode.getNext());
        System.out.println("newNode.i: "+newNode.getI());
        System.out.println("firstNode.next: "+firstNode.getNext());
        System.out.println("firstNode.i: "+firstNode.getI());
    }


}
