package CommonUtils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/13 10:53
 * @email: wangyuhang_mocas@163.com
 */
public class CommonUtils {
    /*生成不重复的32位长的大写字符串*/
    public static String uuid()
    {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    /*b把map转换成javabeen对象*/
    public static <T>  T toBean(Map map,Class<T> clazz) throws Exception {
        /*创建指定类型的javabean对象*/
        T bean=clazz.newInstance();
        /*将数据封装到javabean*/
        BeanUtils.populate(bean,map);
        /*返回javabean*/
        return bean;
    }
}
