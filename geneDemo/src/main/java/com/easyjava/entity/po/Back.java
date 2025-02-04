package com.easyjava.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.easyjava.enums.DatePatternEnum;
import com.easyjava.utils.DateUtil;
import lombok.Data;
import java.math.BigDecimal;

/**
 * @Description:商品退货
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Back implements Serializable {
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
	 * @Description:
	*/
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date time;

	/**
	 * @Description:操作人
	*/
	private String user;

	/**
	 * @Description:退货数量
	*/
	private Integer num;

	/**
	 * @Description:商品规格
	*/
	private String unit;

	/**
	 * @Description:退货价格
	*/
	private BigDecimal price;

	/**
	 * @Description:退货总价格
	*/
	private BigDecimal total;

	/**
	 * @Description:备注
	*/
	private String comment;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",供应商ID:"+(supplierId==null?"空" :supplierId)+",商品ID:"+(goodsId==null?"空" :goodsId)+",支付类型:"+(payType==null?"空" :payType)+",:"+(time==null?"空" :time)+",操作人:"+(user==null?"空" :user)+",退货数量:"+(num==null?"空" :num)+",商品规格:"+(unit==null?"空" :unit)+",退货价格:"+(price==null?"空" :price)+",退货总价格:"+(total==null?"空" :total)+",备注:"+(comment==null?"空" :comment);
	}
}