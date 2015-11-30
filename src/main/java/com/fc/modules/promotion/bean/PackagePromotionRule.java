package com.fc.modules.promotion.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("PackagePromotionRule")
public class PackagePromotionRule extends PromotionRule {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	int BuyPackageId;
	
	@One(target = ProductPackage.class, field = "BuyPackageId")
	ProductPackage BuyPackage;// 买A类产品（按型号可能有多个）若干个
	
	@Many(target = ProductPackage.class, field = "PromotionRuleId")
	List<ProductPackage> DiscountPackages;// 送或者打折B,C,D...类产品（按型号可能有多个）若干个,目前设计最多十类产品
	
	@Column
	int TotalDiscountNumber;// 经销商A产品卖出数量达到100个（包含100），则赠送B类产品+C类产品50套
	@Column
	int FreeNumber; // 赠送数量,买N赠M
	@Column
	Boolean IsAddable;// 折扣是否可以累加
	@Column
	int OrderType;// 折扣针对单独订单 0 还是累计订单 1
	@Column
	Boolean IsMoreFreeAvailable;// 是否多买多送

}
