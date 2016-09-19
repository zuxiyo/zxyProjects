/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月2日下午11:58:29
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月2日下午11:58:29
 */
package com.zxy.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 组织机构实体类
 * @author Zhu XiYong 
 */
@Entity
@Table(name = "Sys_orgs")
public class OrgInfo {
  
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uid")
	private String uid;
	
	@Column(name="sort")
	private int sort;
	
	@Column(name="org_Code")
	private String orgCode;
	
	@Column(name="org_Name")
	private String orgName;
	
	@Column(name="full_Name")
	private String fullName;
	
	@Column(name="english_Name")
	private String englishName;
	
	@Column(name="parent_Code")
	private String parentCode;
	
	@Column(name="org_Type_Code")
	private String orgTypeCode;
	
	@Column(name="org_Type_Name")
	private String orgTypeName;
	
	@Column(name="org_Level_Code")
	private String orgLevelCode;
	
	@Column(name="org_Level_Name")
	private String orgLevelName;
	
	@Column(name="country_Code")
	private String countryCode;
	
	@Column(name="country_Name")
	private String countryName;
	
	@Column(name="region_Code")
	private String regionCode;
	
	@Column(name="region_Name")
	private String regionName;
	
	@Column(name="city_Code")
	private String cityCode;
	
	@Column(name="city_Name")
	private String cityName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="post_Code")
	private String postCode;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="status")
	private boolean status;
	
	/**
	 * 获得组织机构的ID号
	 * 
	 * @return 该组织机构的ID号
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置该组织机构的ID号
	 * 
	 * @param id 该组织机构的ID号
	 */
	public void setUid(String id) {
		this.uid = id;
	}
	/**
	 * 获得该组织机构的排序号
	 * 
	 * @return 该组织机构的排序号
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * 设置该组织机构的排序号
	 * 
	 * @param serialNo 排序号
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * 组织机构代码
	 * @return 组织机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * 要设置的组织机构代码
	 * @param orgCode 要设置的组织机构代码
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * 组织机构名称
	 * @return 组织机构名称
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 要设置的组织机构名称
	 * @param orgName 要设置的组织机构名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 组织机构的完整名称
	 * @return 组织机构的完整名称
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * 设置该组织机构的完整名称
	 * @param fullName 设置该组织机构的完整名称
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * 该组织机构的英语名称
	 * @return 该组织机构的英语名称
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 设置该组织机构的英语名称
	 * @param englishName 设置该组织机构的英语名称
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * 所属上级组织机构代码
	 * @return 所属上级组织机构代码
	 */
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * 设置该组织机构所属上级组织机构代码
	 * @param parentCode 设置该组织机构所属上级组织机构代码
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	/**
	 * 组织机构类型代码
	 * @return 组织机构类型代码
	 */
	public String getOrgTypeCode() {
		return orgTypeCode;
	}
	/**
	 * 设置该组织机构类型代码
	 * @param orgTypeCode 设置该组织机构类型代码
	 */
	public void setOrgTypeCode(String orgTypeCode) {
		this.orgTypeCode = orgTypeCode;
	}
	/**
	 * 组织机构类型代码名称
	 * @return the 组织机构类型代码名称
	 */
	public String getOrgTypeName() {
		return orgTypeName;
	}
	/**
	 * 设置该组织机构类型名称
	 * @param orgTypeName 设置该组织机构类型名称
	 */
	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}
	/**
	 * 获得机构级别
	 * @return 机构级别
	 */
	public String getOrgLevelCode() {
		return orgLevelCode;
	}
	/**
	 * 设置机构级别
	 * 
	 * @param orgLevel 机构级别
	 */
	public void setOrgLevelCode(String orgLevel) {
		this.orgLevelCode = orgLevel;
	}
	/**
	 * 获得机构级别
	 * @return 机构级别
	 */
	public String getOrgLevelName() {
		return orgLevelName;
	}
	/**
	 * 设置机构级别
	 * 
	 * @param orgLevel 机构级别
	 */
	public void setOrgLevelName(String orgLevel) {
		this.orgLevelName = orgLevel;
	}
	
	/**
	 * 国家/地区代码
	 * @return 国家/地区代码
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * 设置该组织机构所在的国家/地区代码
	 * @param countryName 设置该组织机构所在的国家/地区代码
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * 国家/地区代码名称
	 * @return 国家/地区代码名称
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * 设置该组织机构所在的国家/地区名称
	 * @param countryName 设置该组织机构所在的国家/地区名称
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * 该组织机构所在的省或同级的地区代码
	 * @return 该组织机构所在的省或同级的地区代码
	 */
	public String getRegionCode() {
		return regionCode;
	}
	/**
	 * 设置该组织机构所在的省或同级的地区代码
	 * @param regionCode 设置该组织机构所在的省或同级的地区代码
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	/**
	 * 该组织机构所在的省或同级的地区名称
	 * @return 该组织机构所在的省或同级的地区名称
	 */
	public String getRegionName() {
		return regionName;
	}
	/**
	 * 设置该组织机构所在的省或同级的地区名称
	 * 
	 * @param regionName 该组织机构所在的省或同级的地区名称
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	/**
	 * 该组织机构所在的城市代码
	 * @return 该组织机构所在的城市代码
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * 设置该组织机构所在的城市代码
	 * @param cityCode 设置该组织机构所在的城市代码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * 该组织机构所在的城市名称
	 * @return 该组织机构所在的城市名称
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 设置该组织机构所在的城市名称
	 * @param cityName 设置该组织机构所在的城市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 该组织机构的地址
	 * @return 该组织机构的地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 该组织机构的地址
	 * @param address 该组织机构的地址
	 */ 
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 *  邮政编码
	 * @return 邮政编码
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * 邮政编码
	 * @param postCode 邮政编码
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * 传真
	 * @return 传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 传真
	 * @param fax 传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 电话
	 * @return 电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 电话
	 * @param tel 电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
}
