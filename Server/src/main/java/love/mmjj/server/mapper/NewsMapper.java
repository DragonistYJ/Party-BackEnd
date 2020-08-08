package love.mmjj.server.mapper;

import love.mmjj.server.bean.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName NewsMapper
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public interface NewsMapper {
    @Select("SELECT * FROM news")
    List<News> getAll();

    @Select("SELECT * FROM news LIMIT #{begin}, #{end}")
    List<News> getByLimit(int begin, int end);
}
