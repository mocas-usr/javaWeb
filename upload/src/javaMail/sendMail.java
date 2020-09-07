package javaMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/25 10:05
 * @email: wangyuhang_mocas@163.com
 */
public class sendMail {
    public static void main(String[] args) throws MessagingException {
        sendMail sendMail=new sendMail();
        sendMail.fun2();
    }


    public  void fun2() throws MessagingException {
        /*1.得到session*/
        Properties prps=new Properties();
        prps.setProperty("mail.host","smtp.163.com");//设置服务器主机名
        prps.setProperty("mail.smtp.auth","true");//设置需要验证
        /*设置用户名和密码*/
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication () {
                return  new PasswordAuthentication("wangyuhang","123123");//用户名和密码
            }
        };

        Session session=Session.getInstance(prps,auth);

        /*2. 创建MimeMessage对象*/
        MimeMessage msg = new MimeMessage(session);//通过Session对象创建MimeMessage
        msg.setFrom(new InternetAddress("wangyuhang_mocas@163.com"));//设置发信人
        msg.addRecipients(Message.RecipientType.TO,"1179899697@qq.com");//设置多个收信人
        msg.setSubject("测试邮件");//设置主题（标题）
        msg.setContent("hello world!", "text/plain;charset=utf-8");//设置正文
        Transport.send(msg);//发送邮件



    }
}
