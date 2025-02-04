package com.easyjava.entity.query;

import lombok.Data;

/**
 * @Description:公告信息表查询对象
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Noticequery {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:标题
	*/
	private String title;

	private String titleFuzzy;

	/**
	 * @Description:内容
	*/
	private String content;

	private String contentFuzzy;

	/**
	 * @Description:创建时间
	*/
	private String time;

	private String timeFuzzy;

	/**
	 * @Description:创建人
	*/
	private String user;

	private String userFuzzy;

}