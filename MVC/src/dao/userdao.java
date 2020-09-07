package dao;

import domain.user;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/5/17 16:15
 * @email: wangyuhang_mocas@163.com
 */
public interface userdao {
    public user findByUsername(String username) throws SQLException;
    public void add(user user) throws IOException, SQLException, ClassNotFoundException;
}
