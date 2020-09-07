package fmt;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/7 15:47
 * @email: wangyuhang_mocas@163.com
 */
public class mytag implements SimpleTag {

    private PageContext pageContext;
    private JspFragment body;
    @Override/*每次执行标签时，都调用doTag()方法，它是标签处理方法。*/
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("hello,tag!");//输出内容
    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspBody(JspFragment body) {
        this.body=body;

    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.pageContext=(PageContext) jspContext;

    }
}
