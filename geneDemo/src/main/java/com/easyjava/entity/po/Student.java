package com.easyjava.entity.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Description:
 * @Date:2025/02/04
 * @Author: awggwe
 */
@Data
public class Student implements Serializable {
	/**
	 * @Description:
	*/
	private Integer id;

	/**
	 * @Description:
	*/
	private String name;

	/**
	 * @Description:
	*/
	@JsonIgnore
	private String email;

	/**
	 * @Description:
	*/
	private Integer age;

	@Override
	public String toString(){
		return ":"+(id==null?"空" :id)+",:"+(name==null?"空" :name)+",:"+(email==null?"空" :email)+",:"+(age==null?"空" :age);
	}
}