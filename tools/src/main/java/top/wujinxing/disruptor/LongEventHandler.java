package top.wujinxing.disruptor;

import com.lmax.disruptor.EventHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 01397208
 * @date 2023/12/19
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        log.info("Long Event Handler, Event: {}", longEvent);
    }

}
