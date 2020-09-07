package dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/18 16:03
 * @email: wangyuhang_mocas@163.com
 */
public class dbcpdemo {

    public static void main(String[] args) throws SQLException {
        dbcpdemo dbcpdemo=new dbcpdemo();
        dbcpdemo.dpcpDemo();;
    }
    public void dpcpDemo() throws SQLException {
        /*1 创建连接池对象*/
        BasicDataSource dataSource=new BasicDataSource();
        /*2 配置四大参数*/
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql2?useUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("wyh124413");

        /*
        * Resource标签属性
        * name:连接池名称，一般设定为jdbc/databasename
        * auth:设定控制权为容器，固定
        * type:数据类型，固定
        * maxTotal：最大活动连接数，在之前版本中是maxActive
        * maxIdle：最大空闲连接数
        * maxWaitMillis：最大空闲时间，在之前版本中是maxWait
        * */
        /*3 配置连接池参数*/
        dataSource.setMaxTotal(20);//最大活动连接数
        dataSource.setMinIdle(3);//最小空闲连接数
        dataSource.setMaxWaitMillis(1000);
        /*得到连接对象*/
        Connection con=dataSource.getConnection();
        System.out.println(con.getClass().getName());
        /*将连接还给连接池*/
        con.close();

}

}
