package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Studentquery {
	/**
	 * @Description:
	*/
	private Integer id;

	/**
	 * @Description:
	*/
	private String name;

	private String nameFuzzy;

	/**
	 * @Description:
	*/
	private String email;

	private String emailFuzzy;

	/**
	 * @Description:
	*/
	private Integer age;

}