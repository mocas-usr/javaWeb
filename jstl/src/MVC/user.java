package MVC;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/8 9:43
 * @email: wangyuhang_mocas@163.com
 */
/*把数据库查询到的结果放到这一层*/
public class user {
    private String username;
    private String password;

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
