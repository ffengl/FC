package com.fc.modules.promotion.bean;

import java.util.Date;

public class Order {
	int DealerId;
	Date BuyDate;
	ProductOrder orders[];
	PromotionRule matchedRules[];
	void GetMatchRules(PromotionRuleManager prm)//查询所有适用的促销规则
	{
		
	}
	float GetBestPrice(PromotionRule[] rules)//给定促销方案，计算价格
	{
		return 0;
	}
	float GetBestPrice()//自动最优促销价格计算
	{
		return 0;
	}

}
