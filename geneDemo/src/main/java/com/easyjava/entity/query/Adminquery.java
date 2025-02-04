package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:管理员查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Adminquery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:用户名
	*/
	private String username;

	private String usernameFuzzy;

	/**
	 * @Description:密码
	*/
	private String password;

	private String passwordFuzzy;

	/**
	 * @Description:姓名
	*/
	private String name;

	private String nameFuzzy;

	/**
	 * @Description:头像
	*/
	private String avatar;

	private String avatarFuzzy;

	/**
	 * @Description:角色标识
	*/
	private String role;

	private String roleFuzzy;

	/**
	 * @Description:电话
	*/
	private String phone;

	private String phoneFuzzy;

	/**
	 * @Description:邮箱
	*/
	private String email;

	private String emailFuzzy;

}