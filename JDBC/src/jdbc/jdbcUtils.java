package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/19 10:01
 * @email: wangyuhang_mocas@163.com
 */
public class jdbcUtils {
    /*配置文件的默认设置，必须存在src/c3p0-config.xml*/
    private   static ComboPooledDataSource dataSource=new ComboPooledDataSource();

    /*事务专用连接*/
    private static ThreadLocal<Connection> t1=new ThreadLocal<Connection>();

    /*使用连接池返回一个对象*/
    public static Connection getConnection() throws SQLException {
        Connection con=t1.get();//获取自己线程的连接
        /*如果con不等于null，说明已经调用过beginTansation了，已经开启事务*/
        if (con!=null){return con;}
        return   dataSource.getConnection();
    }

    /*返回连接池对象*/
    public static DataSource getDataSources()
    {
        return dataSource;
    }

    /*开启事务
    * 1 获取连接
    * 2 设置autoCommit
    * 3 还要保证dao的连接一致
    * 4 还要让commit和rollback一致
    * */
    public static void beginTransation() throws SQLException {
        Connection con=t1.get();//获取自己线程的连接
        if (con!=null)
        {
            throw new SQLException("已经开启事务，重复开启");
        }
        con=dataSource.getConnection();
        con.setAutoCommit(false);
        t1.set(con);//把当前线程的连接保存起来
    }

    /*提交事务，然后commit*/
    public static void commitTransation() throws SQLException {
        Connection con=t1.get();//获取自己线程的连接
        if (con==null)
        {
            throw new SQLException("还没有开启事务");
        }
        con.commit();
        con.close();

//        con=null;//保证getConnection()，可以返回原con
        t1.remove();
    }
    /*回滚事务*/
    public static void rollbackTransation() throws SQLException {
        Connection con=t1.get();//获取自己线程的连接
        if (con==null)
        {
            throw new SQLException("还没有开启事务");
        }
        con.rollback();
        con.close();
        /*表示事务已经结束了，下次调用getConnection()，返回就不是con*/
//        con=null;
        t1.remove();
    }

    /*释放连接*/
    public static void releaseConnection(Connection connection) throws SQLException {
        /*判断是不是事务专用，如果不是，就要关闭
        * 1 判断是否有连接，没有连接，则没有开启事务，进行关闭
        * 2 如果有连接，但不是事务专用的连接，也进行关闭
        * */

        /*
        * 如果con=null，说明没有事务，那么connection一定不是事务专用
        * */
        Connection con=t1.get();//获取自己线程的连接
        if (con==null)
        {
            connection.close();
        }

        /*
        * 如果con！=null,如果不等于connection，说明参数连接不是事务专用连接
        * */
        if(con!=connection)
        {
            connection.close();
        }
    }
}


