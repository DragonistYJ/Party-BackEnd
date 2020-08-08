package love.mmjj.server.service;

import love.mmjj.server.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GroupService
 * @Author 11214
 * @Date 2020/3/17
 * @Description TODO
 */
@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    public int getGroupIDByAccount(String account) {
        return groupMapper.getGroupIDByAccount(account);
    }

    public List<String> getAccountsByGroupID(int groupID) {
        return groupMapper.getAccountsByGroupID(groupID);
    }

    public String getGroupNameByAccount(String account) {
        return groupMapper.getGroupNameByAccount(account);
    }
}
