package com.fc.modules.promotion.action;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.fc.common.page.Pagination;
import com.fc.common.service.core.BaseAction;
import com.fc.modules.promotion.bean.PromotionRule;
import com.fc.modules.promotion.service.PromotionService;


@IocBean
@At("/promotion")
//@Filters({ @By(type = PrivateFilter.class) })
public class PromotionAction extends BaseAction{
	
    @Inject
    PromotionService promotionService;
    
    @At("/singleindex")
    @Ok("vm:template.promotion.single_index")
    public void index(HttpServletRequest req){
        req.setAttribute("props", System.getProperties());
        
    }
    
    @At
    @Ok("vm:template.promotion.list")
    public Pagination list(@Param("curPage") int curPage, @Param("pageSize") int pageSize, HttpServletRequest req) {
        return promotionService.listPage(curPage, pageSize, "UnitPromotionRule", Cnd.orderBy().desc("create_time"));
    }
    
    @At("/singleadd")
    @Ok("vm:template.promotion.single_add")
    public void add(@Param("pid") String pid, HttpServletRequest req) {
        if (!Strings.isEmpty(pid)) {
            req.setAttribute("parentMenu", promotionService.fetch(pid));
        }
    }

    @At("/add/do")
    @Ok("json")
    public Object addDo(@Param("..") PromotionRule rule, @Param("btns") String btns, @Param("parentId") String parentId, HttpServletRequest req) {
        return null;
    }

    @At("/edit/?")
    @Ok("vm:template.promotion.edit")
    public PromotionRule edit(String id, HttpServletRequest req) {
    	
        return null;
    }

    @At("/edit/do")
    @Ok("json")
    public Object editDo(@Param("..") PromotionRule rule, @Param("pid") String pid, HttpServletRequest req) {
        return null;
    }

    @At("/detail/?")
    @Ok("vm:template.promotion.detail")
    public PromotionRule detail(String id, HttpServletRequest req) {
        return null;
    }


    @At("/delete/?")
    @Ok("json")
    public Object delete(String id, HttpServletRequest req) {
        return null;
    }
}
