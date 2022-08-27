package top.wujinxing.cracking_the_coding_interview;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wujinxing
 * date 2019 2019/8/18 17:08
 * description
 *
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 *
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到最后一个元素。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class ch_3_6_Stack_twoStacks {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        System.out.println(twoStacksSort(num));
    }


    private static ArrayList<Integer> twoStacksSort(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> initStack = new Stack<>();

        //将参数数组压入栈中
        for (int i=0; i<numbers.length; i++){
            initStack.push(numbers[i]);
        }

        Stack<Integer> tempStack = new Stack<>();

        while (!initStack.isEmpty()){
            if (tempStack.isEmpty()){
                tempStack.push(initStack.pop());
            }else{
                //新建变量。存储原始栈中待排序的栈
                int tmp = initStack.pop();
                //将辅助栈中的排好序中的大于tmp的数放入原始栈中
                while (!tempStack.isEmpty()&&tempStack.peek() > tmp){
                    initStack.push(tempStack.pop());
                }
                tempStack.push(tmp);
            }
        }
        while (!tempStack.isEmpty()){
            list.add(tempStack.pop());
        }
        return list;
    }

}
