package love.mmjj.server.service;

import love.mmjj.server.bean.User;
import love.mmjj.server.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getByAccount(String account) {
        return userMapper.getByAccount(account);
    }
}
