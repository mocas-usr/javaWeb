package dao;

import domain.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/17 19:06
 * @email: wangyuhang_mocas@163.com
 */
public class jdbcUserDaoIml implements userdao {
    @Override
    public user findByUsername(String username) throws SQLException {
        /*规范化操作，先初始化，最后回收资源*/
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        System.out.println("jdbcuserdaoimp1");
        try
        {
            /*1 得到连接*/
            System.out.println("jdbcuserdaoimp2");
            con=jdbcUtils.getConnection();
            System.out.println("jdbcuserdaoimp3");
            /*2 准备sql模板,得到pstmt*/
            String sql="select * from tb_stu  where number =?";
            pstmt=con.prepareStatement(sql);
            /*3 为pstmt赋值*/
            pstmt.setString(1,username);
            System.out.println("jdbcuserdaoimp4");

            /*4 执行*/
            rs=pstmt.executeQuery();
            /*5 返回*/
            if (rs==null)
            {
                return null;
            }
            if (rs.next())//返回user对象
            {
                user  user=new user();
                user.setUsername(rs.getString("number"));
                user.setPassword(rs.getString("name"));
                return user;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {throw new RuntimeException(e);}
        finally {
            /*关闭资源*/
            con.close();
            pstmt.close();

        }
    }

    @Override
    public void add(user form) throws IOException, SQLException, ClassNotFoundException {

        /*规范化操作，先初始化，最后回收资源*/
        Connection con=null;
        PreparedStatement pstmt=null;
        try
        {
            /*1 得到连接*/
            con=jdbcUtils.getConnection();
            /*2 准备sql模板,得到pstmt*/
            String sql="insert into tb_stu values(?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            /*3 为pstmt赋值*/
            pstmt.setString(1,form.getUsername());
            pstmt.setString(2,form.getPassword());
            pstmt.setString(3,form.getPassword());
            pstmt.setString(4,form.getUsername());
            /*4 执行*/
            pstmt.executeUpdate();
        }
        catch (Exception e)
        {throw new RuntimeException(e);}
        finally {
            /*关闭资源*/
            con.close();
            pstmt.close();

        }


    }
}
