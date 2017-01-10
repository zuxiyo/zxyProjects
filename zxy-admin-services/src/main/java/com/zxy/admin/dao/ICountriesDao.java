/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日下午1:53:59
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日下午1:53:59
 */
package com.zxy.admin.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zxy.admin.entities.CountryInfo;
import com.zxy.admin.entities.DictionaryCategoryInfo;

/**
 * 国家或地区设置数据层接口
 * @author Zhu XiYong 
 * @Date 2016年9月12日下午1:53:59
 */
public interface ICountriesDao extends PagingAndSortingRepository<CountryInfo,String> {

	/**
	 * 按页获得国家/地区列表
	 * @param pageable
	 * @return
	 */
	Page<CountryInfo> findAllByOrderBySortAsc(Pageable pageable);	
}
