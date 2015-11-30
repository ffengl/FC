package com.fc.modules.promotion.bean;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;

import com.fc.common.service.core.BasePojo;

//@Table("PromotionRule")
public class PromotionRule extends BasePojo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	int RuleID;
	
	@Column
	int DealerId;// 特定的经销商
	
	@Column
	Date startDate;
	
	@Column
	Date endDate;// 打折时间段
	
	@Column
	int BuyPackageId;
	
	@One(target = ProductPackage.class, field = "BuyPackageId")
	ProductPackage BuyPackage;// 买A类产品（按型号可能有多个）若干个
	
	@Column
	int type; // 0: 单品促销; 1:套包促销; 优先级为套包促销优先计算, 然后是单品促销.

}
