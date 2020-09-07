package MVC;

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
 * @Date: 2020/5/8 9:58
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "userServlet",urlPatterns = {"/userServlet"})
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /*一层依赖一层，依赖userservice*/
            userService userservice=new userService();

            /*通过service来完成功能*/
            user user=userservice.find();
            /*把结果保存到request*/
            request.setAttribute("user",user);
            /*将结果转发到jsp显示*/
            request.getRequestDispatcher("/show.jsp").forward(request,response);


    }
}
