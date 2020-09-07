package dom4jtest;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/4/25 15:42
 * @email: wangyuhang_mocas@163.com
 */
public class dom4jtest {
    public static void main(String[] args) throws IOException, DocumentException {
//        add1();
        delstu("101");
    }
    /*添加学生的方法*/
    public static void  add1() throws IOException, DocumentException {
        student   stu=new student("105","wangyu","23");//增加学生类
        add2(stu);

    }
    /*添加指定的学生*具体操作xml/*/
    public static void add2(student student1) throws DocumentException, IOException {
//        /*创建解析器
        SAXReader saxReader=new SAXReader();
        /*得到document*/
        String xmlFile="./xnldom/src/dom4jtest/student.xml";
        Document document=saxReader.read(xmlFile);
        /*得到根节点*/
        Element root=document.getRootElement();
        /*根节点添加stu*/
        Element stu=root.addElement("stu");
        /*获取stu下的三个标签属性*/
        Element id1=stu.addElement("id");
        Element name1=stu.addElement("name");
        Element age1=stu.addElement("age");
        /*给标签属性赋值*/
        id1.setText(student1.getId());
        name1.setText(student1.getName());
        age1.setText(student1.getAge());
        /*回写xml*/
        OutputFormat format= OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(xmlFile),format);
        xmlWriter.write(document);
        xmlWriter.close();

    }
            /*删除指定学生的id*/
    public static void delstu(String id) throws DocumentException, IOException {
//        /*创建解析器
        SAXReader saxReader=new SAXReader();
        /*得到document*/
        String xmlFile="./xnldom/src/dom4jtest/student.xml";
        Document document=saxReader.read(xmlFile);
        /*获取所有id元素*/
        List<Node> list=document.selectNodes("//id");

        for (Node node:list) //node是每个id的元素
        {
            String id1=node.getText();//获取id元素的名称
            /*判断是否与传入id相同*/
            if (id1.equals(id))
            {
                /*获取id元素的父节点*/
                Element stu=node.getParent();
                /*获取stu的父节点student*/
                Element student=stu.getParent();
                /*删除根节点student*/
                student.remove(stu);

            }
            /*回写xml*/
            OutputFormat format= OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(xmlFile),format);
            xmlWriter.write(document);
            xmlWriter.close();
        }
    }
}
