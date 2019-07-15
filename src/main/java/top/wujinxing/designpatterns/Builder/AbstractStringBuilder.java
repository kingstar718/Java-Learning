package top.wujinxing.designpatterns.Builder;

import java.util.Arrays;

/**
 * @author: wujinxing
 * @date: 2019/4/9 17:02
 * @description:
 */
public class AbstractStringBuilder {

    protected char[] value;
    protected int count;

    public AbstractStringBuilder(int capacity){
        count = 0;
        value = new char[capacity];
    }

    public AbstractStringBuilder append(char c){
        ensureCapacityInternal(count+1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacityInternal(int minimunCapacity){
        if (minimunCapacity-value.length > 0){
            eapendCapacity(minimunCapacity);
        }
    }
    void eapendCapacity(int minmunCapacity){
        int newCapacity = value.length*2+2;
        if (newCapacity-minmunCapacity < 0){
            newCapacity = minmunCapacity;
        }
        if (newCapacity < 0){
            if (minmunCapacity < 0){
                throw new OutOfMemoryError();
            }
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}
