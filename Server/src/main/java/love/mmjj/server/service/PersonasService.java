package love.mmjj.server.service;

import love.mmjj.server.bean.Personas;
import love.mmjj.server.mapper.PersonasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PersonasService
 * @Author 11214
 * @Date 2020/3/15
 * @Description TODO
 */
@Service
public class PersonasService {
    @Autowired
    private PersonasMapper personasMapper;

    public List<Personas> getAllByAccount(String account) {
        return personasMapper.getAllByAccount(account);
    }

    public int getMaxFrequencyByAccount(String account) {
        return personasMapper.getMaxFrequencyByAccount(account);
    }

    public int getMinFrequencyByAccount(String account) {
        return personasMapper.getMinFrequencyByAccount(account);
    }
}
