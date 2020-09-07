package wangzhan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/23 15:15
 * @email: wangyuhang_mocas@163.com
 */
@WebFilter(filterName = "wangzhanFilter",urlPatterns = {"/*"})
public class wangzhanFilter implements Filter {
    /*执行获取参数准备*/
    private FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*
        1得到application的map
        2.从request中获得当前客户端的ip地址
        3查看map中是否存在这个ip对应的次数，如果存在则次数加一
        4.如果不存在，次数为1
        */
        /*1得到application的map*/
        ServletContext app=filterConfig.getServletContext();
        Map<String,Integer> map= (Map<String, Integer>) app.getAttribute("map");
        /*获取客户端ip地址*/
        String ip=req.getRemoteAddr();
        /*3进行判断是否第一次访问*/
        if (map.containsKey(ip))
        {
            /*如果存在，保存这个ip访问的次数*/
            int cnt=map.get(ip);
            map.put(ip,cnt+1);
        }
        else
        {
            /*第一次访问时，ip对应key，1是访问次数*/
            map.put(ip,1);
        }
        app.setAttribute("map",map);

        chain.doFilter(req, resp);//这是对于拦截网址的处理，最终要执行的必须
    }
    /*在服务器启动时执行*/
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;

    }

}
