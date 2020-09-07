import jdbcutils.jdbcUtils;

import java.io.IOException;
import java.sql.*;

/**insert into tb_stu values('04152','zhangwei',65,'nan');
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/17 9:24
 * @email: wangyuhang_mocas@163.com
 */
public class demo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        fun3();
    }
    public static void  fun1() throws ClassNotFoundException, SQLException {

        /*/*得到connection,连接成功
        *
        * */
        /*1 准备四大参数*/
        String driveClassName="com.mysql.jdbc.Driver";
        /*jdbc的格式有规范，固定格式，但数据库是自己创建的//jdbc协议:子协议://ip:端口号/数据库名*/
        String url = "jdbc:mysql://localhost:3306/mysql2?useUnicode=true&characterEncoding=utf8";//数据库自己创建
        //数据库用户名
        String name = "root";//将要连接数据库的账户
        String password = "wyh124413";//将要连接数据库的密码

        /*2 加载驱动类*/
        Class.forName(driveClassName);

        /* 3 利用DriverManager 得到connection*/
        Connection con= DriverManager.getConnection(url,name,password);

        /*
        完成增删改
        * */

        /*1 通过connection创建statement*/
        Statement stmt=con.createStatement();
        /*2 使用statement发送sql语句*/
        String sql="insert into tb_stu values('1386','zhangwei',65,'nan')";//增加数据
//        String sql="update tb_stu set name='zhangweida',age=33,gender='na'"+
//                "where number='123'";//修改数据

        int r=stmt.executeUpdate(sql);//执行之后查看影响的行数
        System.out.println(r);


    }
    /*
     * 执行查询操作
     * */
    public static  void  fun2() throws ClassNotFoundException, SQLException {
        /*1 准备四大参数*/
        String driveClassName="com.mysql.jdbc.Driver";
        /*jdbc的格式有规范，固定格式，但数据库是自己创建的//jdbc协议:子协议://ip:端口号/数据库名*/
        String url = "jdbc:mysql://localhost:3306/mysql2?useUnicode=true&characterEncoding=utf8";//数据库自己创建
        //数据库用户名
        String name = "root";//将要连接数据库的账户
        String password = "wyh124413";//将要连接数据库的密码

        /*2 加载驱动类*/
        Class.forName(driveClassName);
        /* 3 利用DriverManager 得到connection*/
        Connection con= DriverManager.getConnection(url,name,password);

        /*
        * 完成查询*/
        /*1 通过connection创建statement*/
        Statement stmt=con.createStatement();
        /*2 调用statement的ResultSet rs=stmt.executeQuery()*/
        ResultSet rs=stmt.executeQuery("select * from tb_stu");
        System.out.println(rs);
        /*3 解析ResultSet查询结果集*/
        /*循环结果集，不断使用rs.next指向下一行*/
        while (rs.next())
        {
          String number=rs.getString(1);//列索引
          String ename=rs.getString("name");//列标签索引
          int age=rs.getInt(3);
          System.out.println(number+","+ename+","+age);


        }

        /*
        * 关闭资源
        * */

        rs.close();
        stmt.close();
        con.close();
    }
    public  static  void fun3() throws SQLException, IOException, ClassNotFoundException {
        Connection con= jdbcUtils.getConnection();
        System.out.println(con);
    }
}
