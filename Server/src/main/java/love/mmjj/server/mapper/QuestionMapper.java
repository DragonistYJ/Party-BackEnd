package love.mmjj.server.mapper;

import love.mmjj.server.bean.Question;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName QuestionsMapper
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
public interface QuestionMapper {
    @Select("SELECT COUNT(*) FROM Questions")
    int countQuestionNumber();

    @Select("SELECT * FROM Questions WHERE id=#{id}")
    Question getOneById(int id);
}
