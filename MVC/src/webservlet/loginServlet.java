package webservlet;

import CommonUtils.CommonUtils;
import domain.user;
import service.userException;
import service.userservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/12 15:41
 * @email: wangyuhang_mocas@163.com
 */
/*user servlet层*/
@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*设置编码*/
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*依赖service*/
        userservice userservice = new userservice();
        user form = null;
        try {
            form = CommonUtils.toBean(request.getParameterMap(), user.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            /*实现登陆*/
            user user=userservice.login(form);
            System.out.println("问题1");
            request.getSession().setAttribute("sessionuser",user);
            response.sendRedirect(request.getContextPath()+"/user/welcome.jsp");
            System.out.println("问题2");
        } catch (userException | SQLException e)
        {
            request.setAttribute("msg",e.getMessage());
            System.out.println("问题3");
//            System.out.println("catch excep");
            /*如果登陆，显示账户姓名*/
            request.setAttribute("user",form);
            System.out.println("问题4");
            /*转发到regist.jsp*/
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
