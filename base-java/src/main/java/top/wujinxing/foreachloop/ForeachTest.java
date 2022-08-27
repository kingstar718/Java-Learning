package top.wujinxing.foreachloop;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: wujinxing
 * @date: 2019/3/14 09:13
 * @description: 不要在foreach循环里进行remove  或操作之后直接break结束循环体
 * foreach语法格式
 * for(元素类型t 元素变量x：遍历对象obj){
 * 引用了x的java语句
 * }
 */
public class ForeachTest {

    @Test
    public void test1() {
        List<String> userNames = ImmutableList.of("Faker", "Uzi", "Clearlove", "Thy Shy");

        System.out.println("使用for循环遍历List");
        for (int i = 0; i < userNames.size(); i++) {
            System.out.println(userNames.get(i));
        }

        //增强for循环，其实是依赖了while循环和Iterator实现的
        System.out.println("使用foreach循环遍历List");
        for (String useName : userNames) {
            System.out.println(useName);
        }

        userNames.forEach(u -> System.out.println(u));

        userNames.forEach(System.out::println);
    }

    @Test
    public void test() {
        //双括弧语法（double-brace syntax）建立并初始化一个List
        List<String> userNames = new ArrayList<String>() {{
            add("Faker");
            add("Uzi");
            add("Clearlove");
            add("Thy Shy");
        }};

       /* for (int i = 0; i < userNames.size(); i++){
            if (userNames.get(i).equals("Faker")){
                userNames.remove(i);
            }
        }*/

        //ConcurrentModificationException错误
        //ArrayList
        //final void checkForComodification() {
        //    if (modCount != expectedModCount)
        //        throw new ConcurrentModificationException();
        //}
        /*for (String userName: userNames
             ) {
            if (userName.equals("Faker")){
                userNames.remove(userName);
            }
        }*/

        Iterator iterator = userNames.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("Faker")) {
                iterator.remove();
            }
        }
        System.out.println(userNames);
    }

}
