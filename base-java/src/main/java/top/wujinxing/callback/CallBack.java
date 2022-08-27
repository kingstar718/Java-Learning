package top.wujinxing.callback;

/**
 * @author wujinxing
 * date 2019 2019/9/7 14:41
 * description
 *
 * //回调指的是A调用B来做一件事，B做完以后将结果告诉给A，这期间A可以做别的事情。
 * //这个接口中有一个方法，意为B做完题目后告诉A时使用的方法。
 * //所以我们必须提供这个接口以便让B来回调。
 * //回调接口，
 */
public interface CallBack {
    void tellAnswer(int res);
}
