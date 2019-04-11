package top.wujinxing.DesignPatterns.Builder;

/**
 * @author: wujinxing
 * @date: 2019/4/9 20:29
 * @description:
 */
public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
