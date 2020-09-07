package MVC;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/8 9:43
 * @email: wangyuhang_mocas@163.com
 */
public class userDao {
    /*把xml查询到的数据，封装到user中*/
    public user find()
    {
        return  new user("zhangsan","1234");
    }
}
