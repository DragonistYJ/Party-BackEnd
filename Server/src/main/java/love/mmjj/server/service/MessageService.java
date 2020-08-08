package love.mmjj.server.service;

import love.mmjj.server.bean.Message;
import love.mmjj.server.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MessageService
 * @Author 11214
 * @Date 2020/3/14
 * @Description TODO
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<Message> getOrderByTimestamp() {
        return messageMapper.getOrderByTimestamp();
    }
}
