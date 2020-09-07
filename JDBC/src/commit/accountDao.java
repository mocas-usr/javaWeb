package commit;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/18 15:05
 * @email: wangyuhang_mocas@163.com
 */
public class accountDao {
    /*修改指定用户的余额*/
    public void updateBalance(Connection con,String ename,double balance)
    {
        try {
            /*1 得到连接对象*/
//            Connection con=jdbcUtils.getConnection();
            /*2 给出sql模板，创建pstmt*/
            String sql="update account set balance=balance+? where name=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            /*3 对参数赋值*/
            pstmt.setDouble(1,balance);
            pstmt.setString(2,ename);
            /*4 执行*/
            pstmt.executeUpdate();

        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
