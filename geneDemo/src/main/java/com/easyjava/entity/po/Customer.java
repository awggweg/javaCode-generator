package com.easyjava.entity.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Description:客户表
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Customer implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:客户名称
	*/
	private String name;

	/**
	 * @Description:客户地址
	*/
	private String address;

	/**
	 * @Description:客户电话
	*/
	private String tel;

	/**
	 * @Description:客户邮箱
	*/
	@JsonIgnore
	private String email;

	/**
	 * @Description:客户邮编
	*/
	private String zipCode;

	/**
	 * @Description:联系人
	*/
	private String user;

	/**
	 * @Description:联系人电话
	*/
	private String phone;

	/**
	 * @Description:开户银行
	*/
	private String bank;

	/**
	 * @Description:开户行账号
	*/
	private String bankCard;

	/**
	 * @Description:状态
	*/
	private String status;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",客户名称:"+(name==null?"空" :name)+",客户地址:"+(address==null?"空" :address)+",客户电话:"+(tel==null?"空" :tel)+",客户邮箱:"+(email==null?"空" :email)+",客户邮编:"+(zipCode==null?"空" :zipCode)+",联系人:"+(user==null?"空" :user)+",联系人电话:"+(phone==null?"空" :phone)+",开户银行:"+(bank==null?"空" :bank)+",开户行账号:"+(bankCard==null?"空" :bankCard)+",状态:"+(status==null?"空" :status);
	}
}