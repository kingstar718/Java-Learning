package top.wujinxing.ch_2_basicjava.java8;

/**
 * @author: wujinxing
 * @date: 2019/3/16 20:42
 * @description:
 * Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法。
 */
public class Test1_def_Interface {
    public static void main(String[] args){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}

interface Formula{
    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}