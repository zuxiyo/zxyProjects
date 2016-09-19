/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午6:11:07
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午6:11:07
 */
package com.zxy.admin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据字典种类实体类
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午6:11:07
 */
@Entity
@Table(name = "sys_dictionary_category")
public class DictionaryCategoryInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "sort")
	private int sort;
	
	@Column(name = "category_Code")
	private String categoryCode;
	
	@Column(name = "category_Name")
	private String categoryName;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "remark")
	private String remark;
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the serialNo
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param state the status to set
	 */
	public void setStatus(boolean state) {
		status = state;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
