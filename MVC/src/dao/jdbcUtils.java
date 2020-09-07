package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/17 14:29
 * @email: wangyuhang_mocas@163.com
 */
public class jdbcUtils {

    private static Properties pro=null;

    static {
        try {
            /*1 加载配置文件*/
            InputStream in1= jdbcUtils.class.getClassLoader().getResourceAsStream("/dao/dbconfig.properties");
            System.out.println(in1);
            pro=new Properties();
            System.out.println("jdbcutils1-1");
            pro.load(in1);
            System.out.println("jdbcutils2");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*2 加载驱动类*/
        try {
            Class.forName(pro.getProperty("driveClassName"));
            System.out.println("jdbcutils3");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*获取连接*/
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        System.out.println("getconnection1");
        /*3 得到connection*/
        return DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("name"),pro.getProperty("password"));

    }
}
