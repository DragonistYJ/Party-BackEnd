package love.mmjj.server.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName GroupMapper
 * @Author 11214
 * @Date 2020/3/17
 * @Description TODO
 */
public interface GroupMapper {
    @Select("SELECT groupID FROM `Group` WHERE account=#{account}")
    int getGroupIDByAccount(String account);

    @Select(("SELECT account FROM `Group` WHERE groupID=#{groupID}"))
    List<String> getAccountsByGroupID(int groupID);

    @Select("SELECT groupName FROM `Group` WHERE account=#{account}")
    String getGroupNameByAccount(String account);
}
