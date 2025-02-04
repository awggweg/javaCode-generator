package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description:日志表
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Logs implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:操作
	*/
	private String operation;

	/**
	 * @Description:操作人
	*/
	private String username;

	/**
	 * @Description:类型
	*/
	private String type;

	/**
	 * @Description:IP地址
	*/
	private String ip;

	/**
	 * @Description:操作时间
	*/
	private String time;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",操作:"+(operation==null?"空" :operation)+",操作人:"+(username==null?"空" :username)+",类型:"+(type==null?"空" :type)+",IP地址:"+(ip==null?"空" :ip)+",操作时间:"+(time==null?"空" :time);
	}
}