package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:日志表查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Logsquery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:操作
	*/
	private String operation;

	private String operationFuzzy;

	/**
	 * @Description:操作人
	*/
	private String username;

	private String usernameFuzzy;

	/**
	 * @Description:类型
	*/
	private String type;

	private String typeFuzzy;

	/**
	 * @Description:IP地址
	*/
	private String ip;

	private String ipFuzzy;

	/**
	 * @Description:操作时间
	*/
	private String time;

	private String timeFuzzy;

}