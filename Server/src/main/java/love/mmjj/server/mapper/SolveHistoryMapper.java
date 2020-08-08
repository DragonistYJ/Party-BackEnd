package love.mmjj.server.mapper;

import love.mmjj.server.bean.SolveHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName SolveHistoryMapper
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public interface SolveHistoryMapper {
    @Select("SELECT * FROM SolveHistory WHERE account=#{account} AND type=#{type}")
    List<SolveHistory> getByUserAndType(String account, int type);

    @Select("SELECT COUNT(*) FROM SolveHistory WHERE account=#{account} AND type=#{type}")
    int countByUserAndType(String account, int type);

    @Select("SELECT questionID FROM SolveHistory WHERE account=#{account} AND type=#{type}")
    List<Integer> getIdsByUserAndType(String account, int type);

    @Insert("INSERT INTO SolveHistory VALUES (#{account}, #{questionID}, #{type})")
    void insertHistory(String account, int questionID, int type);
}
