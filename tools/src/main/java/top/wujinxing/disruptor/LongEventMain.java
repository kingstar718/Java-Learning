package top.wujinxing.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @author 01397208
 * @date 2023/12/19
 */
@Slf4j
public class LongEventMain {

    public static void main(String[] args) throws InterruptedException {
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);
        // 支持lambda形式
        disruptor.handleEventsWith((event, sequence, endOfBatch) -> log.info("Event: {}", event));
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            // 支持lambda形式
            ringBuffer.publishEvent((event, sequence, buffer) -> event.setValue(buffer.getLong(0)), bb);
            Thread.sleep(1000);
        }
    }
}
