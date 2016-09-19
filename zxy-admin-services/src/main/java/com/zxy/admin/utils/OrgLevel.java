/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月4日上午10:07:17
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月4日上午10:07:17
 */
package com.zxy.admin.utils;

/**
 * 组织机构级别
 * 定义组织机构级别，这在做政府的项目中很有用，使用的场景：按级别分类展示等。
 * @author Zhu XiYong 
 * @Date 2016年9月4日上午10:07:17
 */
public enum OrgLevel {
	/**
	 * 省级/自治区/直辖市（在一些国家，省级行政区划称为州）
	 */
	PROVINCE(5),
	/**
	 * 地区级/自治州/盟/地级市/地级县（在一些国家，省级行政区划中县比市大一级）
	 */
	PREFECTURE(4),
	/**
	 * 县级/市辖区/旗
	 */
	COUNTY(3),
	/**
	 * 镇级/乡/街道办事处/区公所/苏木
	 */
	TOWNSHIP(2),
	/**
	 * 村级/社区居民委员会/村民委员会/村民小组
	 */
	VILLAGE(1);

	private int governmentLevel;

	OrgLevel(int level) {
		this.governmentLevel = level;
	}

	/**
	 * 获得组织机构级别
	 * 
	 * @return 组织机构级别
	 */
	public int getLevel() {
		return governmentLevel;
	}
}
