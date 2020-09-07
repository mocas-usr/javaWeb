package bianma;

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
 * @Date: 2020/5/24 9:25
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "bianmaServlet",urlPatterns = {"/bianmaServlet"})
public class bianmaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        response.getWriter().print(username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        response.getWriter().print(username);
    }
}
