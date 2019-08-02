package top.wujinxing.ch_2_basicjava.callbyvalue;

/**
 * @author: wujinxing
 * @date: 2019/4/3 09:46
 * @description: 经典面试题
 */
public class example4 {
    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        example4 ex = new example4();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }
    //在change方法中，str和主程序的str不是一回事，形参的这个str拿到了主程序str值传递，
    //但是，因为string的特殊性，str = "test ok"时，相当于形参的str指向了一个新的对象地址，test ok。
    //并未改变主程序str指向的地址的内容。
    public void change(String str, char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }
}
