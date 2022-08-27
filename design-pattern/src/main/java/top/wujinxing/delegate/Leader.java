package top.wujinxing.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:22
 * description 3.创建一个部门leader的类去实现Target，用这个leader去给员工分配具体的工作任务。
 */
public class Leader implements Target {

    //领导委派员工做具体的事情
    private Map<String, Target> target = new HashMap<>();

    public Leader(){
        //领导委派员工A和员工B分别做不同的事情
        target.put("打印文件", new ATarget());
        target.put("测试项目", new BTarget());
    }

    @Override
    public void doSomething(String commond) {
        target.get(commond).doSomething(commond);
    }
}
