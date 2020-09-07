package upload01;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/24 14:57
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "uploadServlet",urlPatterns = {"/uploadServlet"})
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*上传三步
        * 1.得到工厂
        * 2.通过工厂得到解析器
        * 3.解析request，得到file集合
        * 4.遍历
        * */
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(factory);
        try{
            /*解析request*/
            List<FileItem> fileItems=sfu.parseRequest(request);
            FileItem fi1=fileItems.get(0);
            FileItem fi2=fileItems.get(1);
            System.out.println("普通表单项演示"+fi1.getFieldName()+"="+fi1.getString("utf-8"));
            System.out.println("文件项演示 ： content-type"+fi2.getContentType());
            System.out.println("文件项演示 ：size"+fi2.getSize());
            System.out.println("文件项演示 ：filename"+fi2.getName());

            /*保存文件*/
            File testFile=new File("F:/bai.jpg");
            fi2.write(testFile);
        } catch (FileUploadException e) {
            throw  new RuntimeException(e);

        } catch (Exception e) {
            throw  new RuntimeException(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
