package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/18 18:04
 * @email: wangyuhang_mocas@163.com
 */
public class c3p0Demo {

    public static void main(String[] args) throws PropertyVetoException, SQLException {
        c3p0Demo  c3p0Demo=new c3p0Demo();
        c3p0Demo.c3p0fun2();
    }

    public void c3p0fun1() throws PropertyVetoException, SQLException {
        /*创建连接池对象*/
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        /*对池进行四大参数配置*/
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql2?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("wyh124413");
        /*池配置*/
        dataSource.setAcquireIncrement(5);
        dataSource.setInitialPoolSize(20);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(50);
        /*得到连接*/
        Connection con=dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    /*自动加载c3p0xml配置*/
    public void  c3p0fun2() throws SQLException {
        /*创建连接池对象*/
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        /*得到连接*/
        Connection con=dataSource.getConnection();
        System.out.println(con);
        con.close();
    }
}
