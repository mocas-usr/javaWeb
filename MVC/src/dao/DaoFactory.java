package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/17 16:21
 * @email: wangyuhang_mocas@163.com
 */
/*通过配置文件得到dao实现类的名称
* 通过类名称完成反射
* */
public class DaoFactory {
    private static Properties pro=null;

    static
    {
        try {
            /*1 加载配置文件*/
            /*下面这个路径容易错，/src/dao记得加*/
            System.out.println("daofactory1");
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            System.out.println("daofactory2");

            pro = new Properties();
            pro.load(in);
            System.out.println("daofactory3");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*返回一个具体的实现类，隐藏在工厂中*/
    public static userdao getUserDao()
    {
        /*给出一个配置文件，文件给出userdao的实现类名称
        * 利用反射来建立对象
        * */
        /*得到dao实现类的名称*/
        String daoClaasName=pro.getProperty("dao.userdao");
        System.out.println("usedaofactory");

        /*通过反射类建立对象*/
        try {
            Class clazz=Class.forName(daoClaasName);
            return (userdao) clazz.newInstance();//记的将object转换为userdao
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }


    }
}
