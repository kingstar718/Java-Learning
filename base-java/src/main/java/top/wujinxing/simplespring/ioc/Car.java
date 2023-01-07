package top.wujinxing.simplespring.ioc;

import lombok.Data;

/**
 * @author wujinxing
 * @date 2019/4/2 22:21
 */
@Data
public class Car {

    private String name;

    private String length;

    private String width;

    private String height;

    private Wheel wheel;

}

