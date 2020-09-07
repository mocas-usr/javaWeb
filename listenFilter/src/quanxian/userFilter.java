package quanxian;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/23 19:39
 * @email: wangyuhang_mocas@163.com
 */
@WebFilter(filterName = "userFilter",urlPatterns = {"/quanxian/user.jsp"})
public class userFilter implements Filter {
    public void destroy() {
    }

    /*完成对user.jsp的通行*/
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*得到session*/
        HttpServletRequest request= (HttpServletRequest) req;
        /*判断session中是否含有admin*/
        String name=(String)request.getSession().getAttribute("admin");
        /*如果admin存在，说明身份姓名包含itcast，是会员*/
        if (name!=null)
        {
            chain.doFilter(req, resp);
            return;//结束程序
        }
        /*如果是普通用户即输入了名字，也放行*/
        name=(String)request.getSession().getAttribute("username");
        if (name!=null && !name.trim().isEmpty())//name不是空，并且非空字符串
        {
            chain.doFilter(req, resp);
        }
        else
        {
            /*如果什么都没有，则不放行*/
            request.setAttribute("msg","您啥都不是");
            request.getRequestDispatcher("/quanxian/login.jsp").forward(request,resp);

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
