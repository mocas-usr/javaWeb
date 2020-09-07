package webservlet;

import CommonUtils.CommonUtils;
import domain.user;
import service.userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/12 16:13
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "registServlet",urlPatterns = {"/registServlet"})
public class registServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*设置编码*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        System.out.println("编码问题");
//
        /*依赖service*/
//        System.out.println("tservice");
        userservice userservice=new userservice();
//        System.out.println("问题1");
        user form= null;
        try {
            form = CommonUtils.toBean(request.getParameterMap(), user.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
//            System.out.println("try问题1");

//            System.out.println("try问题2");
            /*实现注册*/
            userservice.regist(form);
            /*要回显示，将表单数据保存*/
//            System.out.println("try问题3");
            response.getWriter().print("<h1>注册成功</h1><br/><a href='"+
                    request.getContextPath()+"/user/login.jsp"+"'>点击这里登陆</a>");

            /*.
            *
            * <h1>注册成功</h1><br/><a href='项目名/user/login.jsp'>点击这里登陆</a>
            *
            * */

        } catch (Exception e) {
            /*获取异常信息，保存到 request域中*/
            request.setAttribute("msg",e.getMessage());
//            System.out.println("catch excep");
            /*如果已经注册，显示账户姓名*/
            request.setAttribute("user",form);
            /*转发到regist.jsp*/
            request.getRequestDispatcher("/user/regist.jsp").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
