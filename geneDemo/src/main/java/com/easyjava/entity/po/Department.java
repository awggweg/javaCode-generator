package com.easyjava.entity.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description:部门表
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Department implements Serializable {
	/**
	 * @Description:ID
	*/
	private Integer id;

	/**
	 * @Description:名称
	*/
	private String name;

	/**
	 * @Description:部门地址
	*/
	private String address;

	/**
	 * @Description:父级ID
	*/
	private Integer pid;

	/**
	 * @Description:层级
	*/
	private Integer level;

	@Override
	public String toString(){
		return "ID:"+(id==null?"空" :id)+",名称:"+(name==null?"空" :name)+",部门地址:"+(address==null?"空" :address)+",父级ID:"+(pid==null?"空" :pid)+",层级:"+(level==null?"空" :level);
	}
}