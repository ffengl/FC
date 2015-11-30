package com.fc.modules.sys.bean;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.ColDefine;
import org.nutz.dao.entity.annotation.ColType;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.Table;

import com.fc.common.service.core.BasePojo;

/**
 * Created by Wizzer.cn on 2015/6/27.
 */
@Table("sys_role")
public class Sys_role extends BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @ColDefine(type = ColType.VARCHAR, width = 64)
    @Prev(els={@EL("uuid()")})
    private String id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    protected String aliasName;
    @Column("is_enabled")
    private boolean enabled;
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String unitid;
    @Column
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String description;
    @Column
    private long location;
    @ManyMany(from="role_id", relation="sys_role_menu", target=Sys_menu.class, to="menu_id")
    protected List<Sys_menu> menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    public List<Sys_menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Sys_menu> menus) {
        this.menus = menus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
