package helloWorld;

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
 * @Date: 2020/5/25 15:06
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "helloServlet",urlPatterns = {"/helloServlet"})
public class helloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        System.out.println("hello,ajaxpost"+username);
        response.getWriter().print("POSThello");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("hello,ajax");
        response.getWriter().print("GEThello");
//        response.getWriter().print("hello2 ");
    }
}
