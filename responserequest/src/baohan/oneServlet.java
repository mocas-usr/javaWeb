package baohan;

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
 * @Date: 2020/4/29 9:32
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "oneServlet",urlPatterns = "/oneServlet")
public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("oneServlet....");
        response.setHeader("aaa","AAA");
        response.getWriter().print("hello one servlet ");

        request.getRequestDispatcher("/twoServlet").include(request,response);
    }
}
