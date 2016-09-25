/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月12日下午1:50:26
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月12日下午1:50:26
 */
package com.zxy.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.zxy.admin.dao.ICountriesDao;
import com.zxy.admin.entities.CountryInfo;

/**
 * 国家或地区设置业务层
 * @author Zhu XiYong 
 * @Date 2016年9月12日下午1:50:26
 */
@Service
public class CountriesService {

	@Autowired
	private ICountriesDao countryDao;

	/**
	 * 检查 国家或地区 是否已存在
	 * @param countryCode
	 * @return 存在 true，不存在 false
	 */
	public boolean exists(String countryCode){
		if(countryDao.exists(countryCode)){
			return true;
		}
		return false;
	}
	
	/**
	 * 新增一个 国家或地区
	 * @param model
	 * @return 新增后的实体
	 * @throws IllegalArgumentException 国家或地区代码【CountryCode】已存在！
	 */ 
	public CountryInfo add(CountryInfo model) {
		
		if(exists(model.getCountryCode())){
			throw new IllegalArgumentException("国家或地区代码【" + model.getCountryCode() +"】已存在！");
		}
		
		CountryInfo result = countryDao.save(model);
		return result;
	}
	
	/**
	 * 更新一个 国家或地区
	 * @param model
	 * @return 更新后的实体
	 */
	public CountryInfo update(CountryInfo model) {
		CountryInfo result = countryDao.save(model);
		return result;	
	}
	
	/**
	 * 删除 一个 国家或地区 信息
	 * @param countryCode
	 * @return
	 */
	public void delete(String countryCode){
		countryDao.delete(countryCode);	
	}
	
	/**
	 *  删除 一批 国家或地区 信息
	 * @param countryCodes
	 */
	public void delete(String[] countryCodes) {
		for(String s:countryCodes)
			delete(s);
	}
	
	/**
	 * 获得数据列表
	 * @param pageable
	 * @return
	 */
	public Page<CountryInfo> getPageList(Pageable pageable) {
		
		if(pageable.getSort() == null){
			Order[] order = { new Order(Direction.ASC,"countryCode"), new Order(Direction.ASC,"sort")};
			Sort sort = new Sort(order);
			pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),sort);
		}
					
		Page<CountryInfo> pageData = countryDao.findAll(pageable);
		return pageData;
	}
	
	/**
	 * 获得一个实体信息类
	 * @param countryCode
	 * @return
	 */
	public CountryInfo getEntity(String countryCode) {	
		return countryDao.findOne(countryCode);
	}

	/**
	 * 获得所有的国家
	 * @return 所有国家列表
	 */
	public Iterable<CountryInfo> getAllCountries() {
		Order[] order = { new Order(Direction.ASC,"countryCode"), new Order(Direction.ASC,"sort")};
		Sort sort = new Sort(order);
		return countryDao.findAll(sort);
	}
}
