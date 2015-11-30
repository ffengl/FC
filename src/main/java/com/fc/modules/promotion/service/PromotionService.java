package com.fc.modules.promotion.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.fc.common.service.core.BaseService;
import com.fc.modules.promotion.bean.PromotionRule;


@IocBean(args = {"refer:dao"})
public class PromotionService extends BaseService<PromotionRule> {
    public PromotionService(Dao dao) {
        super(dao);
    }


}
