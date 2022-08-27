package top.wujinxing.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * @author wujinxing
 * @date 2021-11-20
 */
@ChannelHandler.Sharable
@Slf4j
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    private final String message;

    private int count = 0;

    public MyClientHandler(String message) {
        this.message = message;
    }

    /**
     * 客户端和服务端的连接建立之后就会被调用
     *
     * @param ctx xx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {

        log.info("netty start send message to server");

        try {
            while (true) {
                count++;
                String sendMessage = message + ", count: " + count;
                log.info("thread: {} and send msg: {}", Thread.currentThread().getName(), sendMessage);
                ByteBuf buf = Unpooled.copiedBuffer(sendMessage, CharsetUtil.UTF_8);
                ctx.writeAndFlush(buf);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            log.error("channel active error: ", e);
        }
    }

    /**
     * 客户端接收服务端发送的数据
     *
     * @param ctx /
     * @param msg /
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        try {
            System.out.println("Client receive msg from Server: " + in.toString(CharsetUtil.UTF_8));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    // 处理消息发生异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}