package top.wujinxing.polymorphism;

/**
 * @author 01397208
 * @date 2025/12/31
 * 编译时多态
 * 通过方法重载
 */
public class PolymorphismTest2 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.add(1, 2, 3));
    }

    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b + c;
        }
    }
}
