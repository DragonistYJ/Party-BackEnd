package love.mmjj.server.service;

import love.mmjj.server.bean.Question;
import love.mmjj.server.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QuestionsService
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public int countQuestionNumber() {
        return questionMapper.countQuestionNumber();
    }

    public Question getOneById(int id) {
        return questionMapper.getOneById(id);
    }
}
