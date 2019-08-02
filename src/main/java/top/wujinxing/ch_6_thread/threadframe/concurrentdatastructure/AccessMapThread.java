package top.wujinxing.ch_6_thread.threadframe.concurrentdatastructure;

import java.util.HashMap;
import java.util.Random;

/**
 * @author: wujinxing
 * @date: 2019/3/27 10:55
 * @description:
 */
public class AccessMapThread implements Runnable {
    protected String name;
    private HashMap map;
    private Random rand;
    public AccessMapThread(){}
    public AccessMapThread(String name){
        this.name = name;
    }
    @Override
    public void run() {

    }
    public Object handleMap(int index){
        map.put(rand.nextInt(2000),"DUMMY");
        return map.get(index);
    }
}
