package domain;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/12 15:10
 * @email: wangyuhang_mocas@163.com
 */
public class user {
    private String username;
    private String password;
    private String  verycode;

    public user() {
    }

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user(String username, String password, String verycode) {
        this.username = username;
        this.password = password;
        this.verycode = verycode;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verycode='" + verycode + '\'' +
                '}';
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

    public String getVerycode() {
        return verycode;
    }

    public void setVerycode(String verycode) {
        this.verycode = verycode;
    }
}
