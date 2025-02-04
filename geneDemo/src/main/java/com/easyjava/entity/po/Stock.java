package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品进货
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Stock implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:供应商ID
	*/
	private Integer supplierId;

	/**
	 * @Description:商品ID
	*/
	private Integer goodsId;

	/**
	 * @Description:支付类型
	*/
	private String payType;

	/**
	 * @Description:进货时间
	*/
	private String time;

	/**
	 * @Description:操作人
	*/
	private String user;

	/**
	 * @Description:进货数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	/**
	 * @Description:进货价格
	*/
	private BigDecimal price;

	/**
	 * @Description:进货总价格
	*/
	private BigDecimal total;

	/**
	 * @Description:备注
	*/
	private String comment;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",供应商ID:"+(supplierId==null?"空" :supplierId)+",商品ID:"+(goodsId==null?"空" :goodsId)+",支付类型:"+(payType==null?"空" :payType)+",进货时间:"+(time==null?"空" :time)+",操作人:"+(user==null?"空" :user)+",进货数量:"+(num==null?"空" :num)+",商品规格:"+(unit==null?"空" :unit)+",进货价格:"+(price==null?"空" :price)+",进货总价格:"+(total==null?"空" :total)+",备注:"+(comment==null?"空" :comment);
	}
}