package top.wujinxing.Prototype;

/**
 * @author: wujinxing
 * @date: 2019/4/9 20:40
 * @description:
 */
public class ConcretePrototype extends Prototype {

    private String field;

    public ConcretePrototype(String field){
        this.field = field;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(field);
    }

    @Override
    public String toString() {
        return field;
    }
}
