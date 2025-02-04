package com.easyjava.entity.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Description:管理员
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Staff implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:用户名
	*/
	private String username;

	/**
	 * @Description:密码
	*/
	@JsonIgnore
	private String password;

	/**
	 * @Description:姓名
	*/
	private String name;

	/**
	 * @Description:头像
	*/
	private String avatar;

	/**
	 * @Description:角色标识
	*/
	private String role;

	/**
	 * @Description:性别
	*/
	private String sex;

	/**
	 * @Description:电话
	*/
	private String phone;

	/**
	 * @Description:邮箱
	*/
	@JsonIgnore
	private String email;

	/**
	 * @Description:出生年月
	*/
	private String birth;

	/**
	 * @Description:所属部门ID
	*/
	private Integer departmentId;

	/**
	 * @Description:禁用状态
	*/
	private Integer status;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",用户名:"+(username==null?"空" :username)+",密码:"+(password==null?"空" :password)+",姓名:"+(name==null?"空" :name)+",头像:"+(avatar==null?"空" :avatar)+",角色标识:"+(role==null?"空" :role)+",性别:"+(sex==null?"空" :sex)+",电话:"+(phone==null?"空" :phone)+",邮箱:"+(email==null?"空" :email)+",出生年月:"+(birth==null?"空" :birth)+",所属部门ID:"+(departmentId==null?"空" :departmentId)+",禁用状态:"+(status==null?"空" :status);
	}
}