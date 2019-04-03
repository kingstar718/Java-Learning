package top.wujinxing.KEY_static;

/**
 * @author: wujinxing
 * @date: 2019/2/23 14:38
 * @description:
 */
public class demo2 {
    public demo2(){
        System.out.println("demo2 gouzao");
    }
    private static demo2 d2 = new demo2();
    static {
        System.out.println("static");
    }
    {
        System.out.println("demo2");
    }
}

class demo3 extends demo2 {
    public demo3(){
        System.out.println("demo3 gouzao");
    }
    public static void main(String[] args){
        System.out.println("00000");
        demo3 d3 = new demo3();
    }
}

