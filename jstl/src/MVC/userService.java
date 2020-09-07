package MVC;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/8 9:53
 * @email: wangyuhang_mocas@163.com
 */
public class userService {
    /*service依赖dao层*/
    private userDao userdao=new userDao();

    /*service查询依赖dao完成*/
    public user find()
    {
        return userdao.find();
    }

}
