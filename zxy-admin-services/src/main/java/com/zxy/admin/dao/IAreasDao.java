/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日下午1:54:14
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日下午1:54:14
 */
package com.zxy.admin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.AreaInfo;

/**
 * 行政区划数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月12日下午1:54:14
 */
public  interface IAreasDao extends PagingAndSortingRepository<AreaInfo,String>,JpaSpecificationExecutor<AreaInfo>  {

	/**
	 * 通过国家代码获得下一级的行政区划
	 * @param countryCode
	 * @param parentCode
	 * @return
	 */
	Iterable<AreaInfo> findByCountryCodeAndParentCode(String countryCode,String parentCode);
	
	/**
	 * 获得下一级的行政区划
	 * @param countryCode
	 */
	Iterable<AreaInfo> findByParentCode(String parentCode);

}
