package top.wujinxing.delegate;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:14
 * description 1.创建一个员工干活的接口Target
 * 这里我以一个简单的例子来形容，公司有大boss和部门leader以及部门里的员工，
 * 现在大boss给部门leader下达了任务，而作为部门leader肯定是对任务进行具体的规划然后委派给部门里的员工去完成。
 * 这中间的关系就类似于委派模式。作为大boss他可以不知道任务具体是哪个员工做的，甚至可以不知道员工的存在，
 * 只要以结果为导向，最终能完成任务就可以。作为部门leader相当于一个中介，全程跟进员工的工作进度，
 * 最终像大boss汇报工作。作为员工只要完成任务可以不知道任务最终是大boss 下达的。
 * 接下来就以具体的代码来实现这样一个委派模式的关系
 */
public interface Target {
    public void doSomething(String commond);
}
