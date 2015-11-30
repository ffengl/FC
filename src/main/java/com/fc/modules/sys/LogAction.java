package com.fc.modules.sys;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.fc.common.annotation.SLog;
import com.fc.common.mvc.filter.PrivateFilter;
import com.fc.common.page.Pagination;
import com.fc.common.util.DateUtils;
import com.fc.modules.sys.service.LogService;

/**
 * Created by Wizzer.cn on 2015/7/22.
 */
@IocBean
@At("/private/sys/log")
@Filters({@By(type = PrivateFilter.class)})
@SLog(tag = "日志管理", msg = "")
public class LogAction {
    @Inject
    LogService logService;

    @At("")
    @Ok("vm:template.private.sys.log.index")
    @RequiresPermissions("sys:log")
    @SLog(tag = "日志列表", msg = "访问日志列表")
    public Object index() {
        return "";
    }

    @At
    @Ok("vm:template.private.sys.log.list")
    @RequiresPermissions("sys:log")
    public Pagination list(@Param("curPage") int curPage, @Param("pageSize") int pageSize, HttpServletRequest req) {
        return logService.listPage(curPage, pageSize, "sys_log_" + DateUtils.getYear(), Cnd.orderBy().desc("create_time"));
    }
}
