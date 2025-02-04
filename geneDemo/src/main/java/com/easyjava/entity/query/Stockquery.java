package com.easyjava.entity.query;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品进货查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Stockquery {
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

	private String payTypeFuzzy;

	/**
	 * @Description:进货时间
	*/
	private String time;

	private String timeFuzzy;

	/**
	 * @Description:操作人
	*/
	private String user;

	private String userFuzzy;

	/**
	 * @Description:进货数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	private String unitFuzzy;

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

	private String commentFuzzy;

}