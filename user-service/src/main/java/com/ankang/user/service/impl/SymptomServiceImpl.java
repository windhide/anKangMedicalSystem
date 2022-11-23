package com.ankang.user.service.impl;

import com.ankang.pojo.userService.Symptom;
import com.ankang.user.annotation.AutowireRedis;
import com.ankang.user.mapper.SymptomMapper;
import com.ankang.user.service.SymptomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【symptom】的数据库操作Service实现
 * @createDate 2022-09-14 20:08:35
 */
@Service
public class SymptomServiceImpl extends ServiceImpl<SymptomMapper, Symptom>
        implements SymptomService {
    @AutowireRedis(targetClass = Symptom.class)
    @Override
    public List<Symptom> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Symptom entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Symptom entity) {
        return super.save(entity);
    }
}




