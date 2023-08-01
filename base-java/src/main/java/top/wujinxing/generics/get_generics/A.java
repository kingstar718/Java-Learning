package top.wujinxing.generics.get_generics;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author kingstar718
 * @date 2023/07/31
 */
@Slf4j
public class A<T> {

    private Class<T> clazz;

    public A() {
        Type superclass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        clazz = (Class<T>) type;
    }

    public void printClass() {
        log.info("this generics T class is == {}", clazz);
    }

}
