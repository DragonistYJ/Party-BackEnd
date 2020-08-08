package love.mmjj.server.controller;

import love.mmjj.server.bean.Personas;
import love.mmjj.server.service.PersonasService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PersonasController
 * @Author 11214
 * @Date 2020/3/15
 * @Description TODO
 */
@RestController
@RequestMapping("/personas")
public class PersonasController {
    @Autowired
    private PersonasService personasService;

    @PostMapping("/self-personas")
    public String getPersonas(String account) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("max", personasService.getMaxFrequencyByAccount(account));
        jsonObject.put("min", personasService.getMinFrequencyByAccount(account));
        jsonObject.put("personas", personasService.getAllByAccount(account));
        return jsonObject.toString();
    }
}
