package commit;

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
            InputStream in= jdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");

            pro=new Properties();
            pro.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*2 加载驱动类*/
        try {
            Class.forName(pro.getProperty("driveClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*获取连接*/
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {


        /*3 得到connection*/
        return DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("name"),pro.getProperty("password"));

    }
}
