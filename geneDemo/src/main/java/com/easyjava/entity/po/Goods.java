package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品表
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Goods implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:商品名称
	*/
	private String name;

	/**
	 * @Description:供应商ID
	*/
	private Integer supplierId;

	/**
	 * @Description:商品产地
	*/
	private String producer;

	/**
	 * @Description:商品描述
	*/
	private String descr;

	/**
	 * @Description:销售价格
	*/
	private BigDecimal price;

	/**
	 * @Description:数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	/**
	 * @Description:包装单位
	*/
	private String pack;

	/**
	 * @Description:商品图片
	*/
	private String img;

	/**
	 * @Description:生产批号
	*/
	private String productNo;

	/**
	 * @Description:批准文号
	*/
	private String approveNo;

	/**
	 * @Description:状态
	*/
	private String status;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",商品名称:"+(name==null?"空" :name)+",供应商ID:"+(supplierId==null?"空" :supplierId)+",商品产地:"+(producer==null?"空" :producer)+",商品描述:"+(descr==null?"空" :descr)+",销售价格:"+(price==null?"空" :price)+",数量:"+(num==null?"空" :num)+",商品规格:"+(unit==null?"空" :unit)+",包装单位:"+(pack==null?"空" :pack)+",商品图片:"+(img==null?"空" :img)+",生产批号:"+(productNo==null?"空" :productNo)+",批准文号:"+(approveNo==null?"空" :approveNo)+",状态:"+(status==null?"空" :status);
	}
}