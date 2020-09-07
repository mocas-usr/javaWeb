package jaxptest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/4/25 15:02
 * @email: wangyuhang_mocas@163.com
 */
public class jaxp {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        listname();

    }
    /*遍历所有节点 */
    public static void listname() throws ParserConfigurationException, IOException, SAXException {
        /*创建解析器工厂*/
        DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
        /*创建解析器*/
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        /*得到document*/
        Document document=builder.parse("./xnldom/src/saxtest/p1.xml");

        /*创建方法实现遍历*/
        list1(document);

    }
        /*递归遍历的方法*/
    private static void list1(Node node) {


        /*如果是标签节点，才打印名称，text不打印*/
        if (node.getNodeType()==node.ELEMENT_NODE)
        {
            System.out.println(node.getNodeName());
        }

//        System.out.println(node.getChildNodes());
        NodeList list=node.getChildNodes();

        for (int i=0;i<list.getLength();i++)
        {
            Node list1=list.item(i);

            list1(list1);

        }
    }
}
