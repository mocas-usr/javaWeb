package daotest;

import dao.DaoFactory;
import dao.userdao;
import domain.user;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/13 9:38
 * @email: wangyuhang_mocas@163.com
 */
/*对dao进行测试*/
public class userdaotest {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//        userdaotest userdaotest=new userdaotest();
//        userdaotest.testadd();
//        userdaotest.testFindByname();
    }
    public void testFindByname() throws SQLException {
        userdao userdao= DaoFactory.getUserDao();
        user user=userdao.findByUsername("王五");
        System.out.println(user);

    }
    public void testadd() throws IOException, SQLException, ClassNotFoundException {
        userdao userdao=DaoFactory.getUserDao();

        /*创建用户*/
        user user=new user("wangyudwa","wangwu");
        userdao.add(user);

    }
}
