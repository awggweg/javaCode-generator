package com.easyjava.entity.query;

import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品销售查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Salequery {
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

	private String payTypeFuzzy;

	/**
	 * @Description:销售时间
	*/
	private String time;

	private String timeFuzzy;

	/**
	 * @Description:操作人
	*/
	private String user;

	private String userFuzzy;

	/**
	 * @Description:销售单价
	*/
	private BigDecimal price;

	/**
	 * @Description:销售数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	private String unitFuzzy;

	/**
	 * @Description:销售总价
	*/
	private BigDecimal total;

	/**
	 * @Description:备注
	*/
	private String comment;

	private String commentFuzzy;

}