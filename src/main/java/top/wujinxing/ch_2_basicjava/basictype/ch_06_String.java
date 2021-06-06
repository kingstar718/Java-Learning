package top.wujinxing.ch_2_basicjava.basictype;

/**
 * @author wujinxing
 * date 2019 2019/7/3 16:56
 * description 常见String方法
 */
public class ch_06_String {

    public static void main(String[] args) {

        String s = "abdel os";
        System.out.println(s.length());     //8
        System.out.println(s.indexOf('b')); //1
        System.out.println(s.indexOf("de"));    //2
        System.out.println(s.lastIndexOf('e')); //3
        System.out.println(s.substring(2)); //del os
        System.out.println(s.substring(0, 2));   //ab
        System.out.println(s.trim());   //abdel os
        System.out.println(s.toUpperCase());    //ABDEL OS
        System.out.println(s.charAt(1));    //b
        for (String c : s.split(" ")) {
            System.out.print(c);
            System.out.print('-');  //abdel-os-
        }
        System.out.println();
        for (byte b : s.getBytes()) {
            System.out.print(b);        //97-98-100-101-108-32-111-115-
            System.out.print('-');
        }


    }
}
