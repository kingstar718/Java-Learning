package top.wujinxing.simplespring.ioc;


import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * @date 2019/4/2 20:46
 */
public class SimpleIoc {

    private final Map<String, Object> beanMap = new HashMap<>();

    public SimpleIoc(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("" + "there is no bean with name" + name);
        }
        return bean;
    }

    private void loadBeans(String location) throws Exception {
        //加载xml配置文件
        NodeList nodes;
        try ( InputStream inputStream = new FileInputStream(location)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputStream);
            Element root = doc.getDocumentElement();
            nodes = root.getChildNodes();
        }
        //遍历bean标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");

                //加载beanClass
                Class beanClass;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
                //创建bean
                Object bean = beanClass.newInstance();
                //遍历<property>标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        //利用反射将bean相关字段访问权限设为可访问
                        Field declareField = bean.getClass().getDeclaredField(name);
                        declareField.setAccessible(true);
                        if (StringUtils.isNotBlank(value)) {
                            //将属性值填充到相关字段
                            declareField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (StringUtils.isNotBlank(ref)) {
                                throw new IllegalArgumentException("" + "ref config error");
                            }
                            //将引用填充到相关字段
                            declareField.set(bean, getBean(ref));
                        }
                        //将bean注册到bean容器中
                        registerBean(id, bean);
                    }
                }
            }
        }
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }

}
