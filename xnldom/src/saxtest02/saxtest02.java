package saxtest02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/4/25 11:23
 * @email: wangyuhang_mocas@163.com
 */
public class saxtest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /*创建解析工厂*/
        SAXParserFactory saxfac=SAXParserFactory.newInstance();
        /*创建解析器*/
        SAXParser saxpsr=saxfac.newSAXParser();
        /*执行解析方法*/
        saxpsr.parse("./xnldom/src/saxtest/p1.xml",new default2());
    }
}

/*实现打印xml中name属性*/
class default1 extends DefaultHandler{
    boolean flag=false;
    @Override/*实现遇见<标签，执行函数，自动执行*/
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        /*如果标签名是name*/
        if ("name".equals(qName))
        {
            flag=true;
        }
    }
    @Override/*打印xml中标签内容*/
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (flag==true)
        {
            System.out.println(new String(ch,start,length));
        }
    }
    @Override/*遇见结束符号时的执行函数*/
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(qName))
        {
            flag=false;
        }
    }


}


class default2 extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("<"+qName+">");
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.print(new String(ch,start,length));
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.print("</"+qName+">");
    }


}
