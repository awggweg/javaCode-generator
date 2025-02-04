package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:供应商表查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Supplierquery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:供应商名称
	*/
	private String name;

	private String nameFuzzy;

	/**
	 * @Description:供应商地址
	*/
	private String address;

	private String addressFuzzy;

	/**
	 * @Description:供应商电话
	*/
	private String tel;

	private String telFuzzy;

	/**
	 * @Description:供应商邮箱
	*/
	private String email;

	private String emailFuzzy;

	/**
	 * @Description:邮编
	*/
	private String zipCode;

	private String zipCodeFuzzy;

	/**
	 * @Description:联系人
	*/
	private String user;

	private String userFuzzy;

	/**
	 * @Description:联系人电话
	*/
	private String phone;

	private String phoneFuzzy;

	/**
	 * @Description:开户银行
	*/
	private String bank;

	private String bankFuzzy;

	/**
	 * @Description:开户行账号
	*/
	private String bankCard;

	private String bankCardFuzzy;

	/**
	 * @Description:状态
	*/
	private String status;

	private String statusFuzzy;

}