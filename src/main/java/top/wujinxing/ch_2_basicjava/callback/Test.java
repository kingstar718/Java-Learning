package top.wujinxing.ch_2_basicjava.callback;

/**
 * @author wujinxing
 * date 2019 2019/9/7 14:48
 * description
 */
public class Test {

    public static void main(String[] args) {
        Student tom = new Tom();
        Teacher lee = new Teacher(tom);
        lee.askProblem(tom,lee);
        /**
         * 等学生回答问题的时候老师玩了 0秒的手机
         * 等学生回答问题的时候老师玩了 1秒的手机
         * 等学生回答问题的时候老师玩了 2秒的手机
         * 等学生回答问题的时候老师玩了 3秒的手机
         * work out
         * the answer is 111
         */
    }
}
