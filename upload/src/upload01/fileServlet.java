package upload01;

import cn.itcast.commons.CommonUtils;
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
 * @Date: 2020/5/24 16:02
 * @email: wangyuhang_mocas@163.com
 */
@WebServlet(name = "fileServlet",urlPatterns = {"/fileServlet"})
public class fileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        /*上传三步
         * 1.得到工厂
         * 2.通过工厂得到解析器
         * 3.解析request，得到file集合
         * 4.遍历
         * */
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sfu=new ServletFileUpload(factory);
        try {
            /*解析request*/
            List<FileItem> fileItems = sfu.parseRequest(request);
            FileItem fi1 = fileItems.get(0);
            FileItem fi = fileItems.get(1);
            /*得到根路径*/
            String realPath = getServletContext().getRealPath("/");
            String realPath2=request.getServletPath();
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            String root=this.getServletContext().getRealPath("/WEB-INF/file/");
            String path=Thread.currentThread().getContextClassLoader().getResource("").toString();
            String lujing=this.getClass().getClassLoader().getResource("/").getPath();
            String path2=request.getRealPath("");

            /*生成目录
            * 1 得到文件名称
            * 2 得到hashcode
            * 3 转发成16进制
            * 4.获取前两个字符用来生成目录*/
            String filename=fi.getName();
            /*处理决定路径问题*/
            int index=filename.lastIndexOf("\\");
            if(index != -1) {
                filename = filename.substring(index+1);
            }
            /*文件同名问题，即每个文件添加名称前缀（uuid*/
            String saveName= CommonUtils.uuid()+"_" + filename;

            /*1得到hashcode*/
            int hcode=filename.hashCode();
            String hex=Integer.toHexString(hcode);
            /*获取前两个字符用来生成目录*/
            File dirFile=new File(root,"/"+hex.charAt(0)+"/"+hex.charAt(1));
            /*创建目录链*/
            dirFile.mkdirs();
            /*创建目录文件*/
            File file=new File(dirFile,saveName);
            /*保存*/
//            fi.write(file);
//            fi.write(dirFile);
            fi.write(file);

        } catch (FileUploadException e) {
            throw  new RuntimeException(e);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
