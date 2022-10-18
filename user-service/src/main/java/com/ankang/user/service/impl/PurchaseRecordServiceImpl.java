package com.ankang.user.service.impl;

import com.ankang.pojo.userService.PurchaseRecord;
import com.ankang.user.annotation.AutowireRedis;
import com.ankang.user.mapper.PurchaseRecordMapper;
import com.ankang.user.service.PurchaseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【purchase_record】的数据库操作Service实现
 * @createDate 2022-09-14 20:08:35
 */
@Service
public class PurchaseRecordServiceImpl extends ServiceImpl<PurchaseRecordMapper, PurchaseRecord>
        implements PurchaseRecordService {

    @AutowireRedis(targetClass = PurchaseRecord.class)
    @Override
    public List<PurchaseRecord> list() {
        return super.list();
    }

    @AutowireRedis
    @Override
    public boolean updateById(PurchaseRecord entity) {
        return super.updateById(entity);
    }

    @AutowireRedis
    @Override
    public boolean removeById(PurchaseRecord entity) {
        return super.removeById(entity);
    }

    @AutowireRedis
    @Override
    public boolean save(PurchaseRecord entity) {
        return super.save(entity);
    }

}




