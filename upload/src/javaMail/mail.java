package javaMail;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/25 9:35
 * @email: wangyuhang_mocas@163.com
 */
public class mail {
    public static void main(String[] args) throws IOException {
        mail mail=new mail();
        mail.fun1();
    }

    public void fun1() throws IOException {
        /*编码*/
        String  s="username";
        BASE64Encoder encoder=new BASE64Encoder();
        s=encoder.encode(s.getBytes("utf-8"));
        /*解码*/
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] bytes=decoder.decodeBuffer(s);
        System.out.println(new String(bytes,"utf-8"));

    }
}
