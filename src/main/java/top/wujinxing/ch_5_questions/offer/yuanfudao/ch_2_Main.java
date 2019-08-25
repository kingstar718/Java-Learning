package top.wujinxing.ch_5_questions.offer.yuanfudao;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/24 16:34
 * description
 *
 * 3
 * 3 1 1 1
 * 3 2 2 3
 * 4 0 2 3 99
 *
 * 1
 * 2
 * 3
 * 对于用例1,正好3个不同角色,每个角色1个人选,于是构成且只能构成一个小组
 * 对于用例2,在构成两个小组之后,第3角色单了1人无法构成任何小组,所以最大小组数量是2
 * 对于用例3,学生扎堆选择了最后一个角色,但是第二个角色只有2  个人,所以还是只能构成2个对话小组。
 */
public class ch_2_Main {

    //通过率 0%  但给的测试用例可以通过
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<c; i++){
            int l = sc.nextInt();
            List<Integer> l2 = new ArrayList<>();
            l2.add(l);
            for (int j=0; j<l; j++){
                l2.add(sc.nextInt());
            }
            list.add(l2);
        }*/

        int c = 3;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(3);l1.add(1);l1.add(1);l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);l2.add(2);l2.add(2);l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);l3.add(0);l3.add(2);l3.add(3);l3.add(99);
        list.add(l1);list.add(l2);list.add(l3);
        System.out.println(list);

        for (int i=0; i<c; i++){
            int index = list.get(i).get(0);
            System.out.println(compc(list.get(i)));
        }
        List<Integer> l4 = new ArrayList<>();
        l4.add(5);l4.add(3);l4.add(3);l4.add(4);l4.add(5);l4.add(5);
        System.out.println(compc(l4));
    }
    private static int compc(List<Integer> l){
        int index = l.get(0);
        List<Integer> l2 = new ArrayList<>();
        for (int i=0; i<index; i++){
            l2.add(l.get(i+1));
        }
        Collections.sort(l2);
        int count = 0;
        while (l2.get((l2.size()-3))>0){
            int len = l2.size();
            int c = l2.get(len-1);
            int b = l2.get(len-2);
            int a = l2.get(len-3);
            if (a!=0){
                count += a;
            }
            l2.set(len-3, 0);
            l2.set(len-2, b-a);
            l2.set(len-1, c-a);
            Collections.sort(l2);
        }
        //System.out.println(count);
        return count;
    }


}
