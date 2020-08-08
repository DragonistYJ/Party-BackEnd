package love.mmjj.server.service;

import love.mmjj.server.bean.SolveHistory;
import love.mmjj.server.mapper.SolveHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SolveHistoryService
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@Service
public class SolveHistoryService {
    @Autowired
    private SolveHistoryMapper solveHistoryMapper;

    public List<SolveHistory> getByUserAndType(String account, int type) {
        return solveHistoryMapper.getByUserAndType(account, type);
    }

    public int countByUserAndType(String account, int type) {
        return solveHistoryMapper.countByUserAndType(account, type);
    }

    public List<Integer> getIdsByUserAndType(String account, int type) {
        return solveHistoryMapper.getIdsByUserAndType(account, type);
    }

    public void insertHistory(String account, int questionID, int type) {
        solveHistoryMapper.insertHistory(account, questionID, type);
    }

    public List<SolveHistory> getByUserAndTypeAndChapter(String account, int type) {
        return solveHistoryMapper.getByUserAndType(account, type);
    }
}
