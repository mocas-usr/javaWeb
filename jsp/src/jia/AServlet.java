package jia;

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
 * @Date: 2020/5/4 15:13
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "AServlet",urlPatterns = {"/AServlet"})
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /*获取参数*/
        String s1=request.getParameter("num1");
        String s2=request.getParameter("num2");

        /*转换成int型*/
        int num1=Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);
        /*进行运算*/
        int sum=num1+num2;
        /*把结果放到request域中*/
        request.setAttribute("result",sum);
        /*转换到jsp中*/
        request.getRequestDispatcher("/jia/result.jsp").forward(request,response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
