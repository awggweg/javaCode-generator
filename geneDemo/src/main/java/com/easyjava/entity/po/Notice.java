package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description:公告信息表
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Notice implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:标题
	*/
	private String title;

	/**
	 * @Description:内容
	*/
	private String content;

	/**
	 * @Description:创建时间
	*/
	private String time;

	/**
	 * @Description:创建人
	*/
	private String user;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",标题:"+(title==null?"空" :title)+",内容:"+(content==null?"空" :content)+",创建时间:"+(time==null?"空" :time)+",创建人:"+(user==null?"空" :user);
	}
}