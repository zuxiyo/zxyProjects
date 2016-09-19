/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日下午6:30:11
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日下午6:30:11
 */
package com.zxy.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据字典具体项目实体类
 * @author Zhu XiYong 
 * @Date 2016年9月4日下午6:30:11
 */
@Entity
@Table(name = "sys_dictionary_items")
public class DictionaryItemInfo {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "sort")
	private int sort;
	
	@Column(name = "category_Code")
	private String categoryCode;
	
	@Column(name = "dictionary_Code")
	private String dictionaryCode;
	
	@Column(name = "dictionary_Name")
	private String dictionaryName;
		
	@Column(name = "parent_code")
	private String parentCode;
	
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
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
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
	 * @return the dictionaryCode
	 */
	public String getDictionaryCode() {
		return dictionaryCode;
	}

	/**
	 * @param dictionaryCode the dictionaryCode to set
	 */
	public void setDictionaryCode(String dictionaryCode) {
		this.dictionaryCode = dictionaryCode;
	}

	/**
	 * @return the dictionaryName
	 */
	public String getDictionaryName() {
		return dictionaryName;
	}

	/**
	 * @param dictionaryName the dictionaryName to set
	 */
	public void setDictionaryName(String dictionaryName) {
		this.dictionaryName = dictionaryName;
	}
	/**
	 * @return the parentCode
	 */
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
