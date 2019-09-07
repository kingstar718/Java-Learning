package top.wujinxing.ch_2_basicjava.callback;

/**
 * @author wujinxing
 * date 2019 2019/9/7 14:47
 * description
 */
public class Tom implements Student {

    @Override
    public void resolveProblem(Teacher teacher) {
        try {
            Thread.sleep(3000);
            System.out.println("work out");
            teacher.tellAnswer(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
