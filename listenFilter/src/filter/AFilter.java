package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/23 11:08
 * @email: wangyuhang_mocas@163.com
 */
@WebFilter(filterName = "AFilter",urlPatterns = {"/AServlet"})//urlpatterns是用于拦截的地址，不是filtername
public class AFilter implements javax.servlet.Filter {
    /*在销毁之前执行！在服务器关闭时销毁*/
    public void destroy() {
        System.out.println("过滤器的结果了");
    }
    /*每次过滤时都会执行*/
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截你");
        chain.doFilter(req,resp);
        System.out.println("你回来了 ");
    }

    /*创建之后，马上执行；Filter会在服务器启动时就创建！*/
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器出生了");
    }

}
