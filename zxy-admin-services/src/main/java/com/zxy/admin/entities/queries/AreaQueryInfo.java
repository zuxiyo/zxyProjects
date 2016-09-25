/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月24日上午10:11:42
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月24日上午10:11:42
 */
package com.zxy.admin.entities.queries;

/**
 * 查询条件信息，与View中的查询框条件相同
 * 之所以另外定义一个查询类，是为了，传递的条件更清晰，不跟数据库实体类相混淆。
 * @author Zhu XiYong 
 * @Date 2016年9月24日上午10:11:42
 */
public class AreaQueryInfo {

	private String areaCode;
	private String areaName;
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
