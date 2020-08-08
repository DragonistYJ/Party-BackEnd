package love.mmjj.server.mapper;

import love.mmjj.server.bean.StudyMaterial;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudyMaterialMapper {
    @Select("SELECT * FROM StudyMaterial")
    List<StudyMaterial> getAll();
}
