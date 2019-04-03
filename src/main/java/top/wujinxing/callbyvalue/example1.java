package top.wujinxing.callbyvalue;

/**
 * @author: wujinxing
 * @date: 2019/3/29 14:03
 * @description:
 * 按值调用(call by value)表示方法接收的是调用者提供的值，
 * 而按引用调用（call by reference)表示方法接收的是调用者提供的变量地址。
 * 一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用所对应的变量值。
 *
 * Java程序设计语言总是采用按值调用。
 * 也就是说，方法得到的是所有参数值的一个拷贝，方法不能修改传递给它的任何参数变量的内容。
 */
public class example1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        /**
         * a = 20
         * b = 10
         * num1 = 10
         * num2 = 20
         * 在swap方法中，a、b的值进行交换，并不会影响到 num1、num2。
         * 因为，a、b中的值，只是从 num1、num2 的复制过来的。
         * 也就是说，a、b相当于num1、num2 的副本，副本的内容无论怎么修改，都不会影响到原件本身。
         */
    }

    public static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
