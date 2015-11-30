package com.fc.modules.promotion.bean;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.fc.common.service.core.BasePojo;

@Table("ProductPackage")
public class ProductPackage extends BasePojo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	int Id;
	
	@Column
	int PromotionRuleId;
	
	@Column
	int ProductId;// 产品id
	
	@Column
	int ProductTypeId;// 产品线ID
	
	@Column
	int StartNumber;
	
	@Column
	int EndNumber;// 产品数量，折扣需要购买数量达到StartNumber, 不高于EndNumber;
	
	@Column
	float Price;
	
	@Column
	float DiscountPrice;// 原价，折扣价
	
	@Column
	Boolean IsRebatable;// 返利
	
	@Column
	Boolean IsReturnable;// 是否可以退换货
	
	@Column
	int FreeProductLimit;// 赠品上限

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public int getProductTypeId() {
		return ProductTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		ProductTypeId = productTypeId;
	}

	public int getStartNumber() {
		return StartNumber;
	}

	public void setStartNumber(int startNumber) {
		StartNumber = startNumber;
	}

	public int getEndNumber() {
		return EndNumber;
	}

	public void setEndNumber(int endNumber) {
		EndNumber = endNumber;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public float getDiscountPrice() {
		return DiscountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		DiscountPrice = discountPrice;
	}

	public Boolean getIsRebatable() {
		return IsRebatable;
	}

	public void setIsRebatable(Boolean isRebatable) {
		IsRebatable = isRebatable;
	}

	public Boolean getIsReturnable() {
		return IsReturnable;
	}

	public void setIsReturnable(Boolean isReturnable) {
		IsReturnable = isReturnable;
	}

	public int getFreeProductLimit() {
		return FreeProductLimit;
	}

	public void setFreeProductLimit(int freeProductLimit) {
		FreeProductLimit = freeProductLimit;
	}

}
