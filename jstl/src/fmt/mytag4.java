package fmt;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/7 17:44
 * @email: wangyuhang_mocas@163.com
 */
public class mytag4 extends SimpleTagSupport {
    /*定义一个属性*/
    private  boolean test;
    /*由Tomcat执行，并且在dotag之前*/
    public  void setTest(boolean test){
        this.test = test;
    }
    @Override
    public void doTag() throws JspException, IOException {

        if(test){
            /*执行标签体*/
            this.getJspBody().invoke(null);//如果传递的输出流为null，表示使用的当前页面的out
        }
    }
}
