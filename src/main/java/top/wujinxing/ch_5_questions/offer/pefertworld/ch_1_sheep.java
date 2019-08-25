package top.wujinxing.ch_5_questions.offer.pefertworld;

import java.util.*;

/**
 * @author wujinxing
 * date 2019 2019/8/23 18:17
 * description
 *
 * 员工体重不同，第i个人体重为weight[i]，每艘船承载的最大重量为limit
 * 每艘船最多承载2人，但重量不能超过limit
 * 问最少需要多少只船
 *
 * 第一行输入人员对应体重
 * 第二行湖水如船最大承载重量
 */
public class ch_1_sheep {

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        int limit = sc.nextInt();
        sc.close();
        String[] s1 = s.split(" ");
        for (int i=0; i<s1.length; i++){
            int m = Integer.parseInt(s1[i]);
            list.add(m);
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        int limit = 3;

        Collections.sort(list);
        System.out.println(list);
        int count = 1;

        for (int i=0; i<list.size()-1;){
            if (list.get(i)+list.get(i+1) <= limit){
                i+=2;
                count++;
            }else {
                i++;
                count++;
            }
        }
        System.out.println(count);

        /*int sum = 0;
        for (int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        int result = 0;
        if (sum/limit !=0){
            result = sum/limit +1;
        }else {
            result = sum/result;
        }
        System.out.println(result);*/
    }
}
