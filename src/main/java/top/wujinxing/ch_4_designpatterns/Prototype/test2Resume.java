package top.wujinxing.ch_4_designpatterns.Prototype;

/**
 * @author wujinxing
 * date 2019 2019/8/15 10:46
 * description 下面就是某某的求职简历
 */
public class test2Resume implements Cloneable{

    private String name;
    private String birthday;
    private String sex;
    private String school;
    private String timearea;
    private String company;

    public test2Resume(String name) {
        this.name = name;
    }

    /**
     * @desc 设定个人基本信息
     * @param birthday 生日
     * @param sex 性别
     * @param school 毕业学校
     * @return void
     */
    public void setPersonInfo(String birthday,String sex,String school){
        this.birthday = birthday;
        this.sex = sex;
        this.school = school;
    }

    /**
     * @desc 设定工作经历
     * @param timearea 工作年限
     * @param company 所在公司
     * @return void
     */
    public void setWorkExperience(String timearea,String company){
        this.timearea = timearea;
        this.company = company;
    }

    /**
     * 克隆该实例
     */
    public Object clone(){
        test2Resume resume = null;
        try {
            resume = (test2Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }

    public void display(){
        System.out.println("姓名：" + name);
        System.out.println("生日:" + birthday + ",性别:" + sex + ",毕业学校：" + school);
        System.out.println("工作年限:" + timearea + ",公司:" + company);
    }
}
