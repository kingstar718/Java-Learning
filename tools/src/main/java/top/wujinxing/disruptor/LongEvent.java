package top.wujinxing.disruptor;

/**
 * @author 01397208
 * @date 2023/12/19
 */
public class LongEvent {

    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }

}
