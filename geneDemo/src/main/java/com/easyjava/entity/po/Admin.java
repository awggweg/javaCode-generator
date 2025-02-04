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
public class Admin implements Serializable {
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
	 * @Description:电话
	*/
	private String phone;

	/**
	 * @Description:邮箱
	*/
	@JsonIgnore
	private String email;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",用户名:"+(username==null?"空" :username)+",密码:"+(password==null?"空" :password)+",姓名:"+(name==null?"空" :name)+",头像:"+(avatar==null?"空" :avatar)+",角色标识:"+(role==null?"空" :role)+",电话:"+(phone==null?"空" :phone)+",邮箱:"+(email==null?"空" :email);
	}
}