package top.wujinxing.elasticsearch;

import lombok.Data;

/**
 * @author 01397208
 * @date 2023/10/12
 */
@Data
public class Product {

    private String id;

    private String name;

    private String location;

    private Integer age;

    public Product() {
    }

    public Product(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Product(String id, String name, String location, Integer age) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.age = age;
    }

}
