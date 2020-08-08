package love.mmjj.server.mapper;

import love.mmjj.server.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public interface UserMapper {
    @Select("SELECT * FROM User WHERE account=#{account}")
    User getByAccount(String account);
}
