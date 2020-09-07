package session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/5 10:11
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "loginServlet",urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*获取表单数据*/
        /*处理中文问题*/
        request.setCharacterEncoding("utf-8");
        /*获取*/
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        /*校验登录信息*/
        if (!"itcast".equalsIgnoreCase(username))   //只要不是itcast就算登录成功
        {
            /*将用户信息保存到cookie中*/
            Cookie  cookie=new Cookie("uname",username);
            cookie.setMaxAge(60*60*24);//设置cookie的保存时间
            response.addCookie(cookie);

            HttpSession session=request.getSession();//获取session
            session.setAttribute("username",username);//向session保存用户名
            response.sendRedirect("/jsp_demo/session2/succ1.jsp");//重定向使用的是两个request，
        }
        else
        {
            request.setAttribute("msg","用户名或者密码错误");
            /*转发器，转发*/
            //使用同一个request,如果不适用同一个request，则request保存的信息会消失
            RequestDispatcher qr=request.getRequestDispatcher("/session2/login.jsp");

            qr.forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
