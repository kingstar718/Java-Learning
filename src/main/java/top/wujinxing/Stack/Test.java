package top.wujinxing.Stack;

/**
 * @author: wujinxing
 * @date: 2019/1/9 11:31
 * @description:
 */
public class Test {
    @org.junit.Test
    public void test(){
        //StackInterface<String> stack = new LinkedStack<String>();
        StackInterface<String> stack = new ArrayStack<String>();
        System.out.println(stack.isEmpty());
        stack.push("Aim");
        stack.push("Bill");
        stack.push("Cill");
        stack.push("Dill");
        stack.push("Eill");
        stack.push("Fill");
        System.out.println(stack.peeK());
        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
    }
}
