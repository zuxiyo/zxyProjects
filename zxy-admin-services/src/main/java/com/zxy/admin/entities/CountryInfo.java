/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日上午10:01:40
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日上午10:01:40
 */
package com.zxy.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 国家或地区信息
 * @author Zhu XiYong 
 * @Date 2016年9月12日上午10:01:40
 */
@Entity
@Table(name="sys_countries")
public class CountryInfo {
	@Id
	@Column(name="country_code")
	private String countryCode;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="full_Name")
	private String fullName;
		
	@Column(name="english_name")
	private String englishName;
	
	@Column(name="domain_name")
	private String domainName;
	
	@Column(name="phone_code")
	private String phoneCode;
	
	@Column(name="sort")
	private int sort;
	 
	@Column(name="status")
	private boolean status;

	/**
	 * 国家或地区代码
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 国家或地区代码
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * 国家或地区名称
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * 国家或地区名称
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	/**
	 * 
	 * 国家或地区的完整名称
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 *  国家或地区的完整名称
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 英文名称
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * 英文名称
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * 国际域名缩写
	 * @return the domain_name
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * 国际域名缩写
	 * @param domain_name the domain_name to set
	 */
	public void setDomainName(String domain_name) {
		this.domainName = domain_name;
	}

	/**
	 * 电话区号
	 * @return the phoneCode
	 */
	public String getPhoneCode() {
		return phoneCode;
	}

	/**
	 * 电话区号
	 * @param phoneCode the phoneCode to set
	 */
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	/**
	 * 排序号
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * 排序号
	 * @param sort the sort to set
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * 状态（  true 隐藏，false 显示)
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * 状态（  true 隐藏，false 显示)
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
