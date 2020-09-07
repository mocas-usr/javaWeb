package javabean;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/5 17:25
 * @email: wangyuhang_mocas@163.com
 */
public class person {
    private String name;
    private  int age;
    private String gender;
    private  boolean bool;

    public person() {
    }

    public person(String name, int age, String gender, boolean bool) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bool = bool;
    }

    public String getId()
    {
        return "aaadsa";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bool=" + bool +
                '}';
    }
}
