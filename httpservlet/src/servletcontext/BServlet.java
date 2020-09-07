package servletcontext;

import javax.servlet.ServletContext;
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
 * @Date: 2020/4/27 17:47
 * @email: wangyuhang_mocas@163.com
 */
/*从servletcontext获取数据*/
@WebServlet(name = "BServlet",urlPatterns = {"/BServlet"})
public class BServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*获取ServletContext对象*/
        ServletContext applyca=this.getServletContext();
        /*调用getAttribute来获取数据*/
        String name=(String)applyca.getAttribute("name");
        System.out.println(name);
    }
}
