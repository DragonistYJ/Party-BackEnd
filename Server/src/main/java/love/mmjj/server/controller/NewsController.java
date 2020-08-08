package love.mmjj.server.controller;

import com.google.gson.Gson;
import love.mmjj.server.bean.Message;
import love.mmjj.server.bean.News;
import love.mmjj.server.service.MessageService;
import love.mmjj.server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName NewsController
 * @Author 11214
 * @Date 2020/3/12
 * @Description TODO
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private MessageService messageService;

    @PostMapping("/getNews")
    public String getNews(@RequestParam int from, @RequestParam int end) {
        from = Math.max(from, 0);
        end = Math.max(from + 10, end);
        List<News> all = newsService.getByLimit(from, end);
        return new Gson().toJson(all);
    }

    @PostMapping("/messages")
    public String getMessages() {
        List<Message> messageList = messageService.getOrderByTimestamp();
        return new Gson().toJson(messageList);
    }
}
