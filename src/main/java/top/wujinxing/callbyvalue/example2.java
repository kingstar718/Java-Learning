package top.wujinxing.callbyvalue;

/**
 * @author: wujinxing
 * @date: 2019/3/29 14:12
 * @description: 对象引用作为参数就不一样
 */
public class example2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        /**
         * array 被初始化 arr 的拷贝也就是一个对象的引用，
         * 也就是说 array 和 arr 指向的时同一个数组对象。
         * 因此，外部对引用对象的改变会反映到所对应的对象上
         *
         * 通过 example2 我们已经看到，实现一个改变对象参数状态的方法并不是一件难事。
         * 理由很简单，方法得到的是对象引用的拷贝，对象引用及其他的拷贝同时引用同一个对象。
         */
    }
    public static void change(int[] array){
        //将数组的第一个元素变为0
        array[0] = 0;
    }
}
