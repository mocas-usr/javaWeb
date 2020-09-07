package service;

import dao.DaoFactory;
import dao.userdao;
import domain.user;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/12 15:35
 * @email: wangyuhang_mocas@163.com
 */
public class userservice {
    /*返回一个具体的实现类，隐藏在工厂中*/
    private userdao userdaot= DaoFactory.getUserDao();

    /*实现注册功能*/
    public void  regist(user user) throws userException, IOException, SQLException, ClassNotFoundException {
        /*查询user是否存在*/
        System.out.println("user service1");
        user use=userdaot.findByUsername(user.getUsername());//获取查询的user对象
        System.out.println("user service2");
        if (use!=null)
        {
            throw new userException("用户名"+user.getUsername()+",已经被注册了");
        }
        userdaot.add(user);
        System.out.println("user service");

    }
    /*实现登陆功能*/
    public user  login(user form) throws userException, IOException, SQLException {
        /*查询user是否存在*/
        user use=userdaot.findByUsername(form.getUsername());//获取查询的user对象
        /*登陆过程核对用户*/
        if (use==null)
        {
            throw new userException("用户名不存在");
        }
        if (!form.getPassword().equals(use.getPassword()))
        {
            throw new userException("密码错误");
        }
        /*返回的是查询到的user，而不是form，因为form不包含用户所有信息*/
        return use;
    }

}
