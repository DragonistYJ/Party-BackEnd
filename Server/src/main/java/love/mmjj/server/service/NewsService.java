package love.mmjj.server.service;

import love.mmjj.server.bean.News;
import love.mmjj.server.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName NewsService
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;

    public List<News> getByLimit(int begin, int end) {
        return newsMapper.getByLimit(begin, end);
    }
}
