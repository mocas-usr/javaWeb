package fmt;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/7 17:08
 * @email: wangyuhang_mocas@163.com
 */
public class mytag3 extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        Writer out= this.getJspContext().getOut();//获取当前jsp页面的输出流
        out.write("***************<br/>");/*向页面中输出*/
        this.getJspBody().invoke(out);  //执行标签体内容，将结果输出到指定的流中，即页面上
        out.write("<br/>***************<br/>");
    }
}
