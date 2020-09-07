package service;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/13 9:57
 * @email: wangyuhang_mocas@163.com
 */
/*定义异常类，只给出父辈构造器。方便用来创建对象*/
public class userException extends Exception {
    public userException() {
    }

    public userException(String message) {
        super(message);
    }

    public userException(String message, Throwable cause) {
        super(message, cause);
    }

    public userException(Throwable cause) {
        super(cause);
    }

    public userException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
