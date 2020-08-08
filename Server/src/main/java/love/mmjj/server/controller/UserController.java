package love.mmjj.server.controller;

import com.google.gson.Gson;
import love.mmjj.server.bean.Question;
import love.mmjj.server.bean.SolveHistory;
import love.mmjj.server.bean.User;
import love.mmjj.server.service.QuestionService;
import love.mmjj.server.service.SolveHistoryService;
import love.mmjj.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @ClassName UserController
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SolveHistoryService solveHistoryService;
    @Autowired
    private QuestionService questionsService;
    private Gson gson = new Gson();

    @PostMapping("/login")
    public String login(@RequestParam String account, @RequestParam String password) {
        User user = userService.getByAccount(account);
        if (user == null || !user.getPassword().equals(password)) {
            return "error";
        } else {
            return gson.toJson(user);
        }
    }

    @PostMapping("/error-number")
    public int countError(@RequestParam String account) {
        return solveHistoryService.countByUserAndType(account, SolveHistory.ERROR);
    }

    @PostMapping("/error")
    public String getErrors(@RequestParam String account) {
        List<SolveHistory> solveHistoryList = solveHistoryService.getByUserAndType(account, SolveHistory.ERROR);
        return gson.toJson(solveHistoryList);
    }

    @PostMapping("/solved-all")
    public String countSolving(@RequestParam String account) {
        return solveHistoryService.countByUserAndType(account, SolveHistory.SOLVED) + "-" + questionsService.countQuestionNumber();
    }

    @PostMapping("/question-number")
    public int countAll() {
        return questionsService.countQuestionNumber();
    }

    @PostMapping("/solve")
    public void solveQuestion(String account, int id, String answer, String correct) {
        solveHistoryService.insertHistory(account, id, SolveHistory.SOLVED);
        if (!answer.equals(correct)) {
            solveHistoryService.insertHistory(account, id, SolveHistory.ERROR);
        }
    }

    @PostMapping("/change-question")
    public String changeQuestion(@RequestParam String account, @RequestParam int begin, @RequestParam int step) {
        return getQuestion(account, begin, step);
    }

    private String getQuestion(String account, int begin, int step) {
        Set<Integer> solvedList = new HashSet<>(solveHistoryService.getIdsByUserAndType(account, SolveHistory.SOLVED));
        Set<Integer> errorList = new HashSet<>(solveHistoryService.getIdsByUserAndType(account, SolveHistory.ERROR));
        int number = questionsService.countQuestionNumber();
        int random = new Random().nextInt(100);

        int index = begin;
        while (index >= 1 && index <= number) {
            // 没做过
            if (!solvedList.contains(index)) {
                Question question = questionsService.getOneById(index);
                return gson.toJson(question);
            }
            // 做过了
            else {
                // 做错了
                if (errorList.contains(index)) {
                    Question question = questionsService.getOneById(index);
                    return gson.toJson(question);
                } else {
                    if (random >= 80) {
                        Question question = questionsService.getOneById(index);
                        return gson.toJson(question);
                    }
                }
            }
            index += step;
        }
        if (step > 0) {
            return gson.toJson(questionsService.getOneById(number));
        } else {
            return gson.toJson(questionsService.getOneById(1));
        }
    }

    @PostMapping("/error-question")
    public String getOneError(@RequestParam String account) {
        List<SolveHistory> solveHistoryList = solveHistoryService.getByUserAndTypeAndChapter(account, SolveHistory.ERROR);
        List<Question> questions = new ArrayList<>();
        for (SolveHistory solveHistory : solveHistoryList) {
            questions.add(questionsService.getOneById(solveHistory.getQuestionID()));
        }
        return gson.toJson(questions);
    }
}
