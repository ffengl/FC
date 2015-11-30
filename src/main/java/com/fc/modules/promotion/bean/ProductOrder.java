package com.fc.modules.promotion.bean;

import java.util.Date;

public class ProductOrder {
	int ProductId;// 产品id
	int Number;// 产品数量
	float Price;
	float DiscountPrice;// 原价,折扣价
	float TotalPrice;// 该产品的总价。
	Date ValidateDate;// 效期在哪个时间段打折
	String Lot;// 指定产品批号打折
	int TypeId;// 指定产品大类
	int ModelId;// 指定产品型号
	int OwnerId;// 物权：方承，波科
	int DealerId;// 特定的经销商
	int WareId;// 计入成本仓库销售享受85折，不计入成本仓库出售9折
	Boolean IsRebatable;// 返利
	Boolean IsReturnable;// 是否可以退换货

}
