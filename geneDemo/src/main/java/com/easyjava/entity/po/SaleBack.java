package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品销售退货
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class SaleBack implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:客户ID
	*/
	private Integer customerId;

	/**
	 * @Description:商品ID
	*/
	private Integer goodsId;

	/**
	 * @Description:支付类型
	*/
	private String payType;

	/**
	 * @Description:退货时间
	*/
	private String time;

	/**
	 * @Description:操作人
	*/
	private String user;

	/**
	 * @Description:退货单价
	*/
	private BigDecimal price;

	/**
	 * @Description:退货数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	/**
	 * @Description:退货总价
	*/
	private BigDecimal total;

	/**
	 * @Description:备注
	*/
	private String comment;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",客户ID:"+(customerId==null?"空" :customerId)+",商品ID:"+(goodsId==null?"空" :goodsId)+",支付类型:"+(payType==null?"空" :payType)+",退货时间:"+(time==null?"空" :time)+",操作人:"+(user==null?"空" :user)+",退货单价:"+(price==null?"空" :price)+",退货数量:"+(num==null?"空" :num)+",商品规格:"+(unit==null?"空" :unit)+",退货总价:"+(total==null?"空" :total)+",备注:"+(comment==null?"空" :comment);
	}
}