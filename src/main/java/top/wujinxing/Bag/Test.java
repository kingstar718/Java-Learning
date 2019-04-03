package top.wujinxing.Bag;

/**
 * @author: wujinxing
 * @date: 2019/1/3 23:39
 * @description:
 */
public class Test {
    public static void main(String[] args){
        //数组list测试
        /*BagInterface<String> aBag = new ArrayBag<String>();

        testIsFull(aBag,false);

        String[] contentOfBag01 = {"A","A","B","A","C","A"};
        //testAdd(aBag,contentOfBag01);

        testIsFull(aBag,false);

        //aBag = new ArrayBag<String>(7);

        System.out.println("\nA new empty bag:");
        testIsFull(aBag,false);

        String[] contentOfBag02 = {"A","B","A","C","B","C","D"};
        //testAdd(aBag,contentOfBag02);
        testIsFull(aBag,true);

        System.out.println(aBag.getCurrentSize());
        System.out.println(aBag.contains("B"));
        String[] contentOfBag03 = {"A","B","A","C","B","C","D","A","B","A","C","B","C","D","A","B","A","C","B","C","D","A","B","A","C","B","C","D",
                "A","B","A","C","B","C","D","A","B","A","C","B","C","D","A","B","A","C","B","C","D","A","B","A","C","B","C","D"};
        BagInterface<String> bBag = new ResizableArrayBag<String>();
        testAdd(bBag,contentOfBag03);
        testAdd(aBag,contentOfBag03);*/

        //链表list测试
        System.out.println("Create an empty bag:");
        BagInterface<String> aBag = new LinkedBag<String>();
        testIsFull(aBag,true);
        displayBag(aBag);
        String[] contentOfBag = {"A","B","A","C","B","C","D","A","B"};
        testAdd(aBag,contentOfBag);
        testIsFull(aBag,false);


    }
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.print("Adding to the bag: ");
        for (int index = 0; index < content.length; index++){
            aBag.add(content[index]);
            System.out.print(content[index] + " ");
        }
        System.out.println();
        displayBag(aBag);
    }
    private static void testIsFull(BagInterface<String> aBag, boolean correntResult){
        System.out.print("\n Testing the method isFull with ");
        if(correntResult){
            System.out.println("A full bag!");
        }else{
            System.out.println("A full is not full!");
        }
        System.out.print("isFull finds the bag ");
        if(correntResult && aBag.isFull()){
            System.out.println("full: OK.");
        }else if(correntResult){
            System.out.println("not full. but it is full: ERROR.");
        }else if(!correntResult && aBag.isFull()){
            System.out.println("not full. but it is full: ERROR.");
        }else {
            System.out.println("not full: OK");
        }
    }

    private static void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains the following string(s): ");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++){
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
    }
}
