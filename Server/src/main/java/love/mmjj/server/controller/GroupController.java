package love.mmjj.server.controller;

import love.mmjj.server.bean.User;
import love.mmjj.server.service.GroupService;
import love.mmjj.server.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GroupController
 * @Author 11214
 * @Date 2020/3/17
 * @Description TODO
 */
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;

    @PostMapping("/group")
    public String getGroupInformation(@RequestParam String account) {
        int groupID = groupService.getGroupIDByAccount(account);
        String groupName = groupService.getGroupNameByAccount(account);
        List<String> accounts = groupService.getAccountsByGroupID(groupID);
        List<User> users = new ArrayList<>();
        for (String anAccount : accounts) {
            if (anAccount.equals(account)) continue;
            users.add(userService.getByAccount(anAccount));
        }
        JSONObject result = new JSONObject();
        result.put("groupName", groupName);
        result.put("members", users);
        return result.toString();
    }
}
