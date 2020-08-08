package love.mmjj.server.mapper;

import love.mmjj.server.bean.Personas;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName PersonasMapper
 * @Author 11214
 * @Date 2020/3/15
 * @Description TODO
 */
public interface PersonasMapper {
    @Select("SELECT * FROM Personas WHERE account=#{account}")
    List<Personas> getAllByAccount(String account);

    @Select("SELECT MAX(frequency) FROM Personas WHERE account=#{account}")
    int getMaxFrequencyByAccount(String account);

    @Select("SELECT MIN(frequency) FROM Personas WHERE account=#{account}")
    int getMinFrequencyByAccount(String account);
}
