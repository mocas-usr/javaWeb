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
 * @Date: 2020/4/27 17:31
 * @email: wangyuhang_mocas@163.com
 */
/*向servletcontext保存数据*/
@WebServlet(name = "AServlet")
public class AServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("hello world");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*获取servlet对象   */
        ServletContext application=this.getServletContext();
        /*调用setAttribute来保存数据*/
        application.setAttribute("name","张三");
        System.out.println("DOGET");





    }
}
