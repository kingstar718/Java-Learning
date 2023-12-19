package top.wujinxing.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author 01397208
 * @date 2023/12/19
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
