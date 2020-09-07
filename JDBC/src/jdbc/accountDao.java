package jdbc;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/19 10:16
 * @email: wangyuhang_mocas@163.com
 */
public class accountDao {
    /*实现更改数据*/
    public static void  update(String name,double money) throws SQLException {
        /* QueryRunner的应用*/
        QueryRunner qr=new TxQueryRunner();
        /*sql模板*/
        String sql="update account set balance=balance+? where name=?";
        //准备将params的数据赋值给？
        Object[] params={money,name};
        /*需要自己提供连接，保证使用的是同一个连接*/
//        Connection con= jdbcUtils.getConnection();//这样保证使用同一个connection
        qr.update(sql,params);

        /*如果没有事务，就关闭*/
//        jdbcUtils.releaseConnection(con);

    }
}
