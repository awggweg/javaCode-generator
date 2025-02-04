package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:部门表查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Departmentquery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:名称
	*/
	private String name;

	private String nameFuzzy;

	/**
	 * @Description:部门地址
	*/
	private String address;

	private String addressFuzzy;

	/**
	 * @Description:父级ID
	*/
	private Integer pid;

	/**
	 * @Description:层级
	*/
	private Integer level;

}