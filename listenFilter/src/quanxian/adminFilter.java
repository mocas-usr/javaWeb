package quanxian;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/23 20:51
 * @email: wangyuhang_mocas@163.com
 */
@WebFilter(filterName = "adminFilter",urlPatterns = {"/quanxian/admin.jsp"})
public class adminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*得到session*/
        HttpServletRequest request= (HttpServletRequest) req;
        /*判断session中是否含有admin*/
        String name=(String)request.getSession().getAttribute("admin");
        /*如果admin存在，说明身份姓名包含itcast，是会员*/
        if (name!=null)
        {
            chain.doFilter(req, resp);
        }
        else
        {
            request.setAttribute("msg","您不是admin");
            request.getRequestDispatcher("/quanxian/login.jsp").forward(request,resp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
