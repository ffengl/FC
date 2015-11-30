package com.fc.modules.sys.service;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.fc.common.service.core.BaseService;
import com.fc.modules.sys.bean.Sys_dict;

/**
 * Created by Wizzer.cn on 2015/7/3.
 */
@IocBean(args = { "refer:dao" })
public class DictService extends BaseService<Sys_dict> {
    public DictService(Dao dao) {
        super(dao);
    }

}
