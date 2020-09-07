package commit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/18 15:15
 * @email: wangyuhang_mocas@163.com
 */
/*所有的connection都在service层*/
public class accountService {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        accountService accountService=new accountService();
        accountService.zhuanzhang("zhangsan","lisi",100);
    }


    /*转账方法*/
    public void  zhuanzhang(String from,String to,double money) throws SQLException, IOException, ClassNotFoundException//从谁转账金额
    {
        Connection con=null;
        /*对事务的处理必须使用connection对象*/
        try {
            /*开启事务
            * .....
            * 提交事务
            * */
            //开启连接
            con=jdbcUtils.getConnection();
            //开启事务
            con.setAutoCommit(false);
            /*转账处理*/
            accountDao dao=new accountDao();
            dao.updateBalance(con,from,-money);//转出金额
            dao.updateBalance(con,to,+money);

            //提交事务
            con.commit();
            con.close();
        }
        catch (Exception e)
        {
            /*要回滚事务*/
            con.rollback();
            con.close();
            throw new RuntimeException(e);
        }
    }
}
