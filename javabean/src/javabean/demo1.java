package javabean;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/5 17:31
 * @email: wangyuhang_mocas@163.com
 */
public class demo1 {

    public static void  fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        /*通过反射获取类*/
        String classname="javabean.person";
        Class classzz=Class.forName(classname);
        Object bean=classzz.newInstance();

        BeanUtils.setProperty(bean,"name","zhangsan");
        BeanUtils.setProperty(bean,"age","22");
        BeanUtils.setProperty(bean,"gender","男");
        String age=(String)BeanUtils.getProperty(bean,"age");
        System.out.println(age);
        System.out.println(bean);
    }
    /*将map的数据封装到一个javabean*/
    public static void fun2() throws Exception {
        /*创建hashmap，放置键值对*/
        Map<String,String> map=new HashMap<String,String>();
        map.put("username","zhangsan");
        map.put("password","12345");
        user user=new user();

        /*将map数据放进user*/
        BeanUtils.populate(user,map);
        System.out.println(user);
    }

    public static void main(String[] args) throws Exception {
        fun1();
        fun2();
    }
}
