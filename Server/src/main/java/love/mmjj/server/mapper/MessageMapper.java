package love.mmjj.server.mapper;

import love.mmjj.server.bean.Message;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName MessageMapper
 * @Author 11214
 * @Date 2020/3/14
 * @Description TODO
 */
public interface MessageMapper {
    @Select("SELECT * FROM Message ORDER BY timestamp DESC")
    List<Message> getOrderByTimestamp();
}
