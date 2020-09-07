package jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/19 14:51
 * @email: wangyuhang_mocas@163.com
 */
/*这个类自己处理连接的方法，无需外界处理
* Connection con=jdbcUtils.getConnection();创建连接
* jdbcUtils.releaseConnection(con);完成对连接的释放
* */
public class TxQueryRunner extends QueryRunner {
    public TxQueryRunner() {
        super();
    }

    public TxQueryRunner(boolean pmdKnownBroken) {
        super(pmdKnownBroken);
    }

    public TxQueryRunner(DataSource ds) {
        super(ds);
    }

    public TxQueryRunner(DataSource ds, boolean pmdKnownBroken) {
        super(ds, pmdKnownBroken);
    }


    /*
    *1 建立连接
    * 2 执行父类方法
    *3释放连接
    * 4返回
    * */
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con=jdbcUtils.getConnection();
        int[] result=super.batch(con,sql,params);
        jdbcUtils.releaseConnection(con);
        return result;

}

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con=jdbcUtils.getConnection();
        T result= super.query(con,sql, rsh, params);
        jdbcUtils.releaseConnection(con);
        return  result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {

        Connection con=jdbcUtils.getConnection();
        T result= super.query(con,sql, rsh);
        jdbcUtils.releaseConnection(con);
        return  result;
    }

    @Override
    public int update(String sql) throws SQLException {

        Connection con=jdbcUtils.getConnection();
        int result= super.update(con,sql);
        jdbcUtils.releaseConnection(con);
        return  result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {

        Connection con=jdbcUtils.getConnection();
        int result= super.update(con,sql, param);
        jdbcUtils.releaseConnection(con);
        return  result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {

        Connection con=jdbcUtils.getConnection();
        int result= super.update(con,sql, params);
        jdbcUtils.releaseConnection(con);
        return  result;
    }
}
