package jdbc;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/19 15:22
 * @email: wangyuhang_mocas@163.com
 */
public class demo1 {
    public static void main(String[] args) throws SQLException {
        dbutilsDao dd=new dbutilsDao();
        dd.serviceMethod();
    }
}
