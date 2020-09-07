package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/4/28 16:35
 * @email: wangyuhang_mocas@163.com
 */
/*统计网址的访问量*/
@WebServlet(name = "CServlet",urlPatterns = {"/CServlet"})
public class CServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*获取servlet对象*/
        ServletContext app=this.getServletContext();
        /*设置计数*/
        Integer count=(Integer)app.getAttribute("count");//count是引用对象，包装变量
//        System.out.println(count+"bull");
        if (count!=null)
        {
//            count=1;//自动拆箱，成为基本变量int

            app.setAttribute("count",count+1);


        }
        else
        {
//            int num
            app.setAttribute("count",1);
//            count++;

        }
        System.out.println(count);
        /*向浏览器输出，需要使用响应对象*/
        PrintWriter pw=response.getWriter();
        pw.println("<h1>"+count+"</h1>");


    }
}
