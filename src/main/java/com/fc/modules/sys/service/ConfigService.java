package com.fc.modules.sys.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.fc.common.service.core.BaseService;
import com.fc.modules.sys.bean.Sys_config;

/**
 * Created by Wizzer.cn on 2015/7/3.
 */
@IocBean(args = { "refer:dao" })
public class ConfigService extends BaseService<Sys_config> {
    public ConfigService(Dao dao) {
        super(dao);
    }

}
