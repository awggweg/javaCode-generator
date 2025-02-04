package com.easyjava.entity.query;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品表查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Goodsquery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:商品名称
	*/
	private String name;

	private String nameFuzzy;

	/**
	 * @Description:供应商ID
	*/
	private Integer supplierId;

	/**
	 * @Description:商品产地
	*/
	private String producer;

	private String producerFuzzy;

	/**
	 * @Description:商品描述
	*/
	private String descr;

	private String descrFuzzy;

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

	private String unitFuzzy;

	/**
	 * @Description:包装单位
	*/
	private String pack;

	private String packFuzzy;

	/**
	 * @Description:商品图片
	*/
	private String img;

	private String imgFuzzy;

	/**
	 * @Description:生产批号
	*/
	private String productNo;

	private String productNoFuzzy;

	/**
	 * @Description:批准文号
	*/
	private String approveNo;

	private String approveNoFuzzy;

	/**
	 * @Description:状态
	*/
	private String status;

	private String statusFuzzy;

}