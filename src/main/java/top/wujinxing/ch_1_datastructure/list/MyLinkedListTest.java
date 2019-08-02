package top.wujinxing.ch_1_datastructure.list;

/**
 * @author: wujinxing
 * @date: 2019/3/14 15:58
 * @description:
 */
public class MyLinkedListTest {
    public static void main(String[] args){
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("faker");
        list.add("uzi");
        list.add("clearlove");

        System.out.println(list.get(2));
        list.set(2,"goodlike");
        System.out.println(list.get(2));
        System.out.println(list.size());

        /*iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(list.next());
        }*/
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
