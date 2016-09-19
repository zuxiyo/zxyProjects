/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日上午12:45:43
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日上午12:45:43
 */
package com.zxy.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 行政区划实体类
 * @author Zhu XiYong 
 * @Date 2016年9月12日上午12:45:43
 */
@Entity
@Table(name="sys_areas")
public class AreaInfo {
	
	@Id
	@Column(name="area_Code")
	private String areaCode;
	
	@Column(name="area_name")
	private String areaName;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="english_name")
	private String englishName;
	
	@Column(name="parent_code")
	private String parentCode;
	
	@Column(name="lng")
	private String lng;
	
	@Column(name="lat")
	private String lat;
	
	@Column(name="area_level")
	private String areaLevel;
	
	@Column(name="post_code")
	private String postCode;

	@Column(name="sort")
	private int sort;
	 
	@Column(name="status")
	private boolean status;

	@Column(name="phone_code")
	private String phoneCode;
	
	@Column(name="country_code")
	private String countryCode;
	
	/**
	 * 行政区划代码
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * 行政区划代码
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 行政区划名称
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 行政区划名称
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 行政区划完整名称
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * 行政区划完整名称
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * 行政区划英文名称
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * 行政区划英文名称
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * 上级行政区划代码
	 * @return the parentCode
	 */
	public String getParentCode() {
		return parentCode;
	}

	/**
	 * 上级行政区划代码
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	/**
	 * 经度 
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * 经度
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * 纬度 
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * 纬度 
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * 行政区划等级
	 * @return the areaLevel
	 */
	public String getAreaLevel() {
		return areaLevel;
	}

	/**
	 * 行政区划等级
	 * @param areaLevel the areaLevel to set
	 */
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}

	/**
	 * 邮政编码
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * 邮政编码
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * 国别代码
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * 设置国别代码
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
