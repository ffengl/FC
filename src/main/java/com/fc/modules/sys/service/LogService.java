package com.fc.modules.sys.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.fc.common.service.core.BaseService;
import com.fc.modules.sys.bean.Sys_log;

/**
 * Created by Wizzer.cn on 2015/7/22.
 */
@IocBean(args = {"refer:dao"})
public class LogService extends BaseService<Sys_log> {
    public LogService(Dao dao) {
        super(dao);
    }

    public void update(Sys_log log) {
        dao().update(log);
    }

}
