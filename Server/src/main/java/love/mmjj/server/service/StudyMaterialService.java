package love.mmjj.server.service;

import love.mmjj.server.bean.StudyMaterial;
import love.mmjj.server.mapper.StudyMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudyMaterialService
 * @Author 11214
 * @Date 2020/3/13
 * @Description TODO
 */
@Service
public class StudyMaterialService {
    @Autowired
    private StudyMaterialMapper studyMaterialMapper;

    public List<StudyMaterial> getAll() {
        return studyMaterialMapper.getAll();
    }
}
