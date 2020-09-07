package dao;

import domain.user;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/12 15:28
 * @email: wangyuhang_mocas@163.com
 */
/*数据类,userdao的某一实现类*/
public class userdaoimp implements userdao {
    private String  path="F:/javaweb/MVC/user.xml";//依赖数据文件，用绝对路径，相对路径不稳定

    /*按用户名查询*/
    public user findByUsername(String username)
    {
        /*创建解析器*/
        SAXReader reader=new SAXReader();
        try {
            /*通过xpath查询得到元素*/
            Document doc=reader.read(path);
            Element ele=(Element) doc.selectSingleNode("//user[@username='"+username+"']");
            System.out.println("userdaoimp");
            /*如果查询不到元素，返回空*/
            if (ele==null)
            {
               return null;
            }
            /*把ele数据封装到user对象中*/
            user user=new user();
            String name=ele.attributeValue("username");//获取元素名称为username的属性值
            String password=ele.attributeValue("password");//获取元素名称为password    的属性值

            /*封装到user里面*/
            user.setUsername(name);
            user.setPassword(password);
            return user;

        } catch (DocumentException e) {
            throw new RuntimeException(e);//抛出异常
        }

    }


    /*添加用户*/
    public void add(user user) throws IOException {
        /*创建解析器*/
        SAXReader reader=new SAXReader();

        try {
            /*创建document*/
            Document doc=reader.read(path);
            /*创建根元素*/
            Element root=doc.getRootElement();
            /*通过根元素创建新元素  */
            Element userele=root.addElement("user");//要加add是添加元素
            /*设置属性*/
            userele.addAttribute("username",user.getUsername());
            userele.addAttribute("password",user.getPassword());
            /*保存文档，回写xml*/
            OutputFormat format = OutputFormat.createPrettyPrint();//回写xml的排版，有缩进的效果（createCompactFormat:没缩进）
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
            xmlWriter.write(doc);
            xmlWriter.close();

        } catch (DocumentException | FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
