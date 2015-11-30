package com.fc.modules.sys.bean;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import com.fc.common.service.core.BasePojo;

/**
 * Created by Wizzer.cn on 2015/7/1.
 */
@Table("sys_user_oauth")
public class Sys_user_oauth extends BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column("user_id")
    @ColDefine(type = ColType.VARCHAR, width = 64)
    protected String userId;

}
