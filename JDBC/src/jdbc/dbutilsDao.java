package jdbc;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/19 11:06
 * @email: wangyuhang_mocas@163.com
 */
public class dbutilsDao {

    private accountDao dao = new accountDao();

    public void serviceMethod() throws SQLException {

        try {
            //开启事务
            jdbcUtils.beginTransation();
            /*事务处理*/
            dao.update("zhangsan",+100);
            if (true) throw new RuntimeException("出点异常");
            dao.update("lisi",-100);

            //提交事务
            jdbcUtils.commitTransation();
        } catch (SQLException e) {
            jdbcUtils.rollbackTransation();
        }
    }
}
