package love.mmjj.server.controller;

import com.google.gson.Gson;
import love.mmjj.server.bean.StudyMaterial;
import love.mmjj.server.service.StudyMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName StudyController
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@RestController
@RequestMapping("/study")
public class StudyController {
    @Autowired
    private StudyMaterialService studyMaterialService;

    @PostMapping("/study-material")
    public String getStudyMaterials(@RequestParam int from, @RequestParam int end) {
        from = Math.max(from, 0);
        end = Math.max(from + 40, end);
        List<StudyMaterial> studyMaterials = studyMaterialService.getAll();
        studyMaterials = studyMaterials.subList(from, Math.min(studyMaterials.size(), end));
        return new Gson().toJson(studyMaterials);
    }
}
