package quanxian;

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
 * @Date: 2020/5/23 16:48
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "quanxianServlet",urlPatterns = {"/quanxianServlet"})
public class quanxianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*获取用户名
        * 如果包含itcast，则是管理员
        * 如果不是，则是普通会员
        * 登录的用户名称保存到session中
        * 转发到index.jsp
        * */
    /*设置编码格式*/
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        if (username.contains("itcast"))
        {
            request.getSession().setAttribute("admin",username);
        }
        else
        {
            request.getSession().setAttribute("username",username);
        }
        request.getRequestDispatcher("/quanxian/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
