package chongfuzhuce;

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
 * @Date: 2020/5/25 16:14
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "validServlet",urlPatterns = {"/validServlet"})
public class validServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        /*获取参数username*/
        String username=request.getParameter("username");
        if (username.equalsIgnoreCase("itcast"))//如果等于这个字符串，不考虑大小写
        {
            response.getWriter().print("1");//如果是则等于1

        }
        else
        {
                response.getWriter().print("0");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
