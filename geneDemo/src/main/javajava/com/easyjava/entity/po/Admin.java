package com.easyjava.entity.po;

import java.io.Serializable;

/**
 * @Description:管理员
 * @Date:2025/01/19
 * @Author: awggwe
 */
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
	private String email;

}