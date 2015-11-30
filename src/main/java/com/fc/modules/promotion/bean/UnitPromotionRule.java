package com.fc.modules.promotion.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("UnitPromotionRule")
public class UnitPromotionRule extends PromotionRule {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	float Price;// 原价
	
	@Column
	float Discount; //折扣
	
	@Column
	float DiscountPrice; //折扣价
	
	@Column
	String Lot;// 指定产品批号打折
	
	@Column
	int ProductTypeId;// 指定产品线大类
	
	@Column
	int ProductModelId;// 指定产品型号
	
	@Column
	int OwnerId;// 物权：方承，波科
	
	@Column
	int WareId;// 计入成本仓库销售享受85折，不计入成本仓库出售9折
	
	@Column
	Boolean IsRebatable;// 返利
	
	@Column
	Boolean IsReturnable;// 是否可以退换货
	
	@Column
	Boolean IsAddable;// 折扣是否可以累加，
	
	@Column
	int OrderType;// 折扣针对单独订单 0 还是累计订单 1

}
